package string;

//https://leetcode.com/problems/implement-strstr/

public class _28_ImplementStrStr {
    //KMP

    private int[] buildPrefix(char[] pattern) {
        int n = pattern.length;
        int[] prefix = new int[n];
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (len > 0 && pattern[len] != pattern[i]) {
                len = prefix[len - 1];
            }
            if (pattern[len] == pattern[i]) {
                len++;
            }
            prefix[i] = len;
        }
        return prefix;
    }

    public int strStr(String txt, String pattern) {
        int m = txt.length();
        int n = pattern.length();
        if (n == 0) {
            return 0;
        } else if (m == 0) {
            return -1;
        }
        char[] tChars = txt.toCharArray();
        char[] pChars = pattern.toCharArray();

        int[] prefix = buildPrefix(pChars);
        int i = 0, j = 0;
        while (i < m) {
            if (tChars[i] == pChars[j]) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else {
                if (j > 0) {
                    j = prefix[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

}
