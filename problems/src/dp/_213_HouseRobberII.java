package dp;

//https://leetcode.com/problems/house-robber-ii/

public class _213_HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] robFirst = new int[n];
        robFirst[0] = 0;
        robFirst[1] = nums[0]; // rob first
        for (int i = 2; i < n; i++) {
            int value = nums[i - 1];
            robFirst[i] = Math.max(robFirst[i - 1], robFirst[i - 2] + value);
        }

        int[] skipFirst = new int[n + 1];
        skipFirst[0] = 0;
        skipFirst[1] = 0; // skip first
        for (int i = 2; i <= n; i++) {
            int value = nums[i - 1];
            skipFirst[i] = Math.max(skipFirst[i - 1], skipFirst[i - 2] + value);
        }
        return Math.max(robFirst[n - 1], skipFirst[n]);
    }
}
