package string;

// https://leetcode.com/problems/longest-palindromic-substring/

public class _5_LongestPalindromicSubstring {


    int n = 0;
    char[] chars;

    public String longestPalindrome(String s) {
        chars = s.toCharArray();
        n = chars.length;

        int startIdx = 0, maxLen = 1;
        for (int i = 0; i < n; i++) {
            int biggerLen = Math.max(detect(i, i), detect(i, i + 1));
            if (biggerLen > maxLen) {
                maxLen = biggerLen;
                startIdx = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(startIdx, startIdx + maxLen);
    }

    private int detect(int i, int j) {
        while (i >= 0 && j < n && chars[i] == chars[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
