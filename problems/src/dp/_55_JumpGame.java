package dp;

// https://leetcode.com/problems/jump-game/
public class _55_JumpGame {

//    Constraints:
//            1 <= nums.length <= 104
//            0 <= nums[i] <= 105

    public static boolean canJump(int[] nums) {
        int n= nums.length;
        if (n==1) {
            return true;
        }

        // dp[i] : farthest position can jump from i
//        int[] dp = new int[n];
//        dp[0] = nums[0];
        int dp = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (dp >= i) {
                // reachable
                dp = Math.max(dp, i + nums[i]);
            }

            if (dp >= n - 1) {
                return true;
            }
        }

        return dp >= n - 1;
    }

    public static void main(String[] args) {
        boolean b1 = canJump(new int[]{2, 3, 1, 1, 4});
        boolean b2 = canJump(new int[]{3, 2, 1, 0, 4});
        boolean b3 = canJump(new int[]{1, 2});
        boolean b4 = canJump(new int[]{2, 0, 0});
        boolean b5 = canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
        boolean b6 = canJump(new int[]{0, 2, 3});
    }
}
