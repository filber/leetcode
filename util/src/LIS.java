import java.util.Arrays;

public class LIS {
    // Longest Increasing Subsequence

    public static int LongestDecreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j]>=nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static int LongestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        // dp[i] represents the longest increasing subsequence ending with i
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<=nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                300, 207, 155, 300, 299, 156, 158, 65
        };
        // 5 - [300,300,299,156,65]
        int m1 = LongestDecreasingSubsequence(arr);
        // 3 - [155,156,158]
        int m2 = LongestIncreasingSubsequence(arr);

    }
}
