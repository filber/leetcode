package dp;

// https://leetcode.com/problems/jump-game/
public class _55_JumpGame {

    public static boolean canJump(int[] nums) {
        int n = nums.length;

        int lastIndex = n - 1;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < i) {
                // can't reach i
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            if (dp[i] >= lastIndex) {
                // could reach lastIndex
                return true;
            }
        }
        // single element
        return true;
    }
}
