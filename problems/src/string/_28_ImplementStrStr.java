package string;

//https://leetcode.com/problems/implement-strstr/

public class _28_ImplementStrStr {
    //KMP

    private int[] buildPrefix(char[] pattern) {
        int j = 0;
        int n = pattern.length;
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = prefix[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            prefix[i] = j;
        }
        return prefix;
    }

    public int strStr(String txt, String pattern) {
        char[] tChars = txt.toCharArray();
        int n = tChars.length;
        char[] pChars = pattern.toCharArray();
        int m = pChars.length;
        if (m == 0) {
            return 0;
        }
        int[] prefix = buildPrefix(pChars);

        int i = 0, j = 0;
        while (i < n) {
            if (tChars[i] == pChars[j]) {
                i++;
                j++;
                if (j == m) {
                    return i - m;
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
