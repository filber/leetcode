package string;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class _3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] chCnt = new int[128];
        int l = 0, r = 0, len = 0;
        while (r < n) {
            char ch = chars[r];
            if (chCnt[ch] == 0) {
                chCnt[ch] = 1;
                r++;
                len = Math.max(len, r - l);
            } else {
                char lCh = chars[l];
                chCnt[lCh] = 0;
                l++;
            }
        }
        return len;
    }
}
