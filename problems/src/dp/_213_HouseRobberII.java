package dp;

//https://leetcode.com/problems/house-robber-ii/

public class _213_HouseRobberII {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int skipLast = rob(nums, 0, n - 2);
        int skipFirst = rob(nums, 1, n - 1);

        int max = Math.max(skipLast, skipFirst);
        return max;
    }

    private static int rob(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[start++];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start++]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int r1 = rob(new int[]{2, 3, 2}); // 3
        int r2 = rob(new int[]{1, 2, 3, 1}); //4
        int r3 = rob(new int[]{1, 2, 3}); //3

    }
}
