package dp;

//https://leetcode.com/problems/house-robber-ii/

public class _213_HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] SkipFirst = new int[n + 1];
        int[] RobFirst = new int[n + 1];

        // initialization
        SkipFirst[0] = 0;
        SkipFirst[1] = 0;
        RobFirst[0] = 0;
        RobFirst[1] = nums[0];

        // iterate
        for (int i = 2; i <= n; i++) {
            int amt = nums[i - 1];
            SkipFirst[i] = Math.max(SkipFirst[i - 1], SkipFirst[i - 2] + amt);
            RobFirst[i] = Math.max(RobFirst[i - 1], RobFirst[i - 2] + amt);
        }
        int result = Math.max(SkipFirst[n], RobFirst[n - 1]);
        return result;
    }
}
