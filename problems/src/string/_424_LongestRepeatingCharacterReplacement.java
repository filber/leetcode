package string;

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class _424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        int n = chars.length;
        int l = 0, mCnt = 0;
        for (int r = 0; r < n; r++) {
            char rCh = chars[r];
            count[rCh - 'A']++;
            if (count[rCh - 'A'] > mCnt) {
                mCnt = count[rCh - 'A'];
            }

            if (mCnt + k < r - l + 1) {
                char lCh = chars[l];
                count[lCh - 'A']--;
                l++;
            }
        }
        return Math.min(n, mCnt + k);
    }
}