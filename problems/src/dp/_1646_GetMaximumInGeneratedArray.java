package dp;

// https://leetcode.com/problems/get-maximum-in-generated-array/

public class _1646_GetMaximumInGeneratedArray {

    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int m0 = getMaximumGenerated(0);
        int m1 = getMaximumGenerated(1);
        int m2 = getMaximumGenerated(2);
        int m3 = getMaximumGenerated(3);
        int m7 = getMaximumGenerated(7);
    }


}
