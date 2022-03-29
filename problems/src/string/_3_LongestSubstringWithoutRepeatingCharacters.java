package string;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] charCnt = new int[128];
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int len = 0;
        while (r < n) {
            char rCh = chars[r];
            if (charCnt[rCh] == 0) {
                r++;
                charCnt[rCh] = 1;
            } else {
                char lCh = chars[l];
                charCnt[lCh] = 0;
                l++;
            }
            len = Math.max(len, r - l);
        }

        return len;
    }
}
