package tp;

// https://leetcode.com/problems/longest-palindromic-substring/

public class _5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = -1;
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            // odd chars
            int oddLen = detect(chars, i, i);
            if (oddLen > maxLen) {
                maxLen = oddLen;
                // [0,<1>,2]
                start = i - oddLen / 2;
            }
            // even chars
            int evenLen = detect(chars, i, i + 1);
            if (evenLen > maxLen) {
                maxLen = evenLen;
                // [0,<1,2>,3]
                start = i - evenLen / 2 + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Get length of the longest palindrome substring expanded from <l,r>
    private int detect(char[] chars, int l, int r) {
        // Guard condition
        if (l < 0 || r == chars.length || chars[l] != chars[r]) {
            return 0;
        }
        // Expand to both directions
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
