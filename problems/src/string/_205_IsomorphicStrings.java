package string;

// https://leetcode.com/problems/isomorphic-strings/

import java.util.Arrays;

public class _205_IsomorphicStrings {

    // Bijection
    public static boolean isIsomorphic(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }

        int[] left2right = new int[128];
        Arrays.fill(left2right, -1);
        int[] right2left = new int[128];
        Arrays.fill(right2left, -1);

        for (int i = 0; i < left.length(); i++) {
            int leftCh = left.charAt(i);
            int rightCh = right.charAt(i);

            if (left2right[leftCh] == -1) {
                left2right[leftCh] = rightCh;
            } else {
                if (left2right[leftCh] != rightCh) {
                    return false;
                }
            }

            if (right2left[rightCh] == -1) {
                right2left[rightCh] = leftCh;
            } else {
                if (right2left[rightCh] != leftCh) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean b1 = isIsomorphic("egg", "add"); // true
        boolean b2 = isIsomorphic("foo", "bar"); // false
        boolean b3 = isIsomorphic("bar", "foo"); // false
        boolean b4 = isIsomorphic("paper", "title"); // true
    }
}
