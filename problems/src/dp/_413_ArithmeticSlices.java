package dp;

//https://leetcode.com/problems/arithmetic-slices/

public class _413_ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int cnt = 0;
//        int[] dp = new int[n];
        int dp = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                // dp[i] = dp[i-1] + 1;
                // cnt += dp[i];
                dp += 1;
                cnt += dp;
            } else {
                dp = 0;
            }
        }

        return cnt;
    }
}
