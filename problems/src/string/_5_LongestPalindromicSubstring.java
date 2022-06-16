package string;

// https://leetcode.com/problems/longest-palindromic-substring/

public class _5_LongestPalindromicSubstring {


    int n;
    char[] chars;

    public String longestPalindrome(String s) {
        chars = s.toCharArray();
        n = chars.length;
        int maxLen = 0;
        int beginIdx = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.max(detect(i, i), detect(i, i + 1));
            if (len > maxLen) {
                maxLen = len;
                beginIdx = i - (len - 1) / 2;
            }
        }

        return s.substring(beginIdx, beginIdx + maxLen);
    }

    private int detect(int i, int j) {
        while (i >= 0 && j < n && chars[i] == chars[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}
