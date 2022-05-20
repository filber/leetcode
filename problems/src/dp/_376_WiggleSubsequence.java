package dp;

//https://leetcode.com/problems/wiggle-subsequence/

public class _376_WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int down = 1;
        int up = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }

        return Math.max(down, up);
    }

    public int wiggleMaxLengthDP(int[] nums) {
        int n = nums.length;
        // N[i-1] > N[i]
        int[] down = new int[n];
        // N[i-1] < N[i]
        int[] up = new int[n];
        down[0] = 1;
        up[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i - 1] > nums[i]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                //nums[i - 1] == nums[i]
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[n - 1], up[n - 1]);
    }
}
