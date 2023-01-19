package dp;

//https://leetcode.com/problems/flip-string-to-monotone-increasing/

public class _926_FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int dpM = 0;
        int dpZ = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '1') {
                dpZ = dpZ + 1;
            } else {
                dpM = Math.min(dpM + 1, dpZ);
            }
        }
        return dpM;
    }
}
