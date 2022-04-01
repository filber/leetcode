package string;

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class _424_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        int n = chars.length;
        int l = 0, r = 0, majorityCnt = 0;
        while (r < n) {
            char rCh = chars[r++];
            int rCnt = ++count[rCh - 'A'];
            if (rCnt > majorityCnt) {
                majorityCnt = rCnt;
            }
            if (r - l > majorityCnt + k) {
                char lCh = chars[l++];
                count[lCh - 'A']--;
            }
        }

        return Math.min(n, majorityCnt + k);
    }
}