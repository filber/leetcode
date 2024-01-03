package greedy;

// https://leetcode.com/problems/jump-game-ii/

public class _45_JumpGameII {

    public int jump(int[] nums) {
        int mostRightPosition = 0;
        int mostRightJump = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            mostRightPosition = Math.max(mostRightPosition, i + nums[i]);
            if (i == mostRightJump) {
                mostRightJump = mostRightPosition;
                jumps++;
                if (mostRightJump >= nums.length - 1) {
                    return jumps;
                }
            }
        }

        return jumps;
    }
}
