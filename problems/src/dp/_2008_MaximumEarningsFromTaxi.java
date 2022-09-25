package dp;

//https://leetcode.com/problems/maximum-earnings-from-taxi/

import java.util.Arrays;

public class _2008_MaximumEarningsFromTaxi {

    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (j < rides.length && rides[j][1] == i) {
                int[] ride = rides[j];
                dp[i] = Math.max(dp[i], dp[ride[0]] + ride[1] - ride[0] + ride[2]);
                j++;
            }
        }
        return dp[n];
    }
}
