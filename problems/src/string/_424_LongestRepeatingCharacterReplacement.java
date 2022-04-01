package string;

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class _424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, r = 0;
        int maxCount = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        while (r < n) {
            char rCh = chars[r++];
            int rCnt = ++count[rCh - 'A'];
            if (rCnt > maxCount) {
                maxCount = rCnt;
            }
            if (r - l > maxCount + k) {
                char lCh = chars[l++];
                count[lCh - 'A']--;
            }
        }
        return Math.min(maxCount + k, n);
    }
}
