package string;

// https://leetcode.com/problems/isomorphic-strings/

import java.util.Arrays;

public class _205_IsomorphicStrings {

    // Bijection
    public boolean isIsomorphic(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }

        int[] lProjection = new int[128];
        Arrays.fill(lProjection, -1);
        int[] rProjection = new int[128];
        Arrays.fill(rProjection, -1);
        char[] lChars = left.toCharArray();
        char[] rChars = right.toCharArray();
        int n = lChars.length;

        for (int i = 0; i < n; i++) {
            int lChar = lChars[i];
            int rChar = rChars[i];
            if (lProjection[lChar] == -1) {
                lProjection[lChar] = rChar;
            } else if (lProjection[lChar] != rChar) {
                return false;
            }

            if (rProjection[rChar] == -1) {
                rProjection[rChar] = lChar;
            } else if (rProjection[rChar] != lChar) {
                return false;
            }
        }

        return true;
    }
}
