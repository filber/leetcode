package dp;

// https://leetcode.com/problems/partition-array-for-maximum-sum/
public class _1043_PartitionArrayForMaximumSum {
//  Constraints:
//      1 <= arr.length <= 500
//      0 <= arr[i] <= 109
//      1 <= k <= arr.length

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int j = i; j >= 0 && i - j < k; j--) {
                max = Math.max(max, arr[j]);
                int preSum = j > 0 ? dp[j - 1] : 0;
                dp[i] = Math.max(dp[i], max * (i - j + 1) + preSum);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
      //    Output: 84
      //    Explanation: arr becomes [15,15,15,9,10,10,10]
      int m1 = maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3);

      //    Output: 83
      int m2 = maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4);
      //    Output: 1
      int m3 = maxSumAfterPartitioning(new int[]{1}, 1);
    }
}
