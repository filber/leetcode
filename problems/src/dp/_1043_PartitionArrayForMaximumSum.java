package dp;

// https://leetcode.com/problems/partition-array-for-maximum-sum/
public class _1043_PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i <= n; i++) {
            int max = arr[i - 1];
            for (int j = i; (i - j + 1) <= k && j > 0; j--) {
                max = Math.max(max, arr[j - 1]);
                int width = i - j + 1;
                dp[i] = Math.max(dp[i], dp[j - 1] + max * width);
            }
        }
        return dp[n];
    }
}
