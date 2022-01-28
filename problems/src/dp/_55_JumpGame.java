package dp;

// https://leetcode.com/problems/jump-game/
public class _55_JumpGame {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int mostRightPos = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i <= mostRightPos) {
                int rightPosFromI = i + nums[i];
                mostRightPos = Math.max(mostRightPos, rightPosFromI);
                if (mostRightPos >= n - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean b1 = canJump(new int[]{2, 3, 1, 1, 4}); // true
        boolean b2 = canJump(new int[]{3, 2, 1, 0, 4}); // false
        boolean b3 = canJump(new int[]{1, 2}); // true
        boolean b4 = canJump(new int[]{2, 0, 0}); // true
        boolean b5 = canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}); // true
        boolean b6 = canJump(new int[]{0, 2, 3}); // false
        boolean b7 = canJump(new int[]{0}); // true
    }
}
