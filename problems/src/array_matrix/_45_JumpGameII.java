package array_matrix;

// https://leetcode.com/problems/jump-game-ii/

public class _45_JumpGameII {

    // two pointers
    public static int jump(int[] nums) {
        int l = 0, r = 0, max = 0, count = 0;
        while (r < nums.length - 1) {
            for (int i = l; i <= r; i++) {
                if (nums[i] + i > max) {
                    max = nums[i] + i;
                }
            }
            l = r + 1;
            r = max;
            count++;
        }
        return count;
    }

    public int jumpGreedy(int[] nums) {
        int n = nums.length;
        int mostRightPosition = 0;
        int mostRightJump = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            mostRightPosition = Math.max(mostRightPosition, i + nums[i]);
            if (i == mostRightJump) {
                mostRightJump = mostRightPosition;
                jumps++;
                if (mostRightJump >= n - 1) {
                    return jumps;
                }
            }
        }

        return 0;
    }
}
