package dp;

// https://leetcode.com/problems/jump-game/
public class _55_JumpGame {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int mostRightPos = 0;
        for (int i = 0; i < n; i++) {
            if (i <= mostRightPos) {
                mostRightPos = Math.max(mostRightPos,i + nums[i]);
            }

            if (mostRightPos >= n - 1) {
                return true;
            }
        }

        return false;
    }
}
