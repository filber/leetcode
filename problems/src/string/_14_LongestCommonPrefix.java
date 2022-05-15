package string;

//https://leetcode.com/problems/longest-common-prefix/

import java.util.Arrays;

public class _14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        char[] chars = longestCommonPrefix(strs, 0, strs.length - 1);
        return new String(chars);
    }

    private char[] longestCommonPrefix(String[] strs, int i, int j) {
        if (i == j) {
            return strs[i].toCharArray();
        }
        int mid = (i + j) / 2;
        char[] leftChars = longestCommonPrefix(strs, i, mid);
        if (leftChars.length == 0) {
            return leftChars;
        }
        char[] rightChars = longestCommonPrefix(strs, mid + 1, j);
        if (rightChars.length == 0) {
            return rightChars;
        }
        char[] ans = new char[Math.min(leftChars.length, rightChars.length)];
        int idx = 0;
        while (idx < ans.length && leftChars[idx] == rightChars[idx]) {
            ans[idx] = leftChars[idx];
            idx++;
        }
        return Arrays.copyOf(ans, idx);
    }
}
