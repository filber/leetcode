package dp;

//https://leetcode.com/problems/house-robber/
public class _198_HouseRobber {
//    Constraints:
//            1 <= nums.length <= 100
//            0 <= nums[i] <= 400
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }

//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
        int preTwo = 0;
        int preOne = nums[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
//            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            max = Math.max(preOne, preTwo + nums[i]);
            preTwo = preOne;
            preOne = max;
        }
        return max;
    }


    public static void main(String[] args) {
        int r1 = rob(new int[]{1, 2, 3, 1}); //1+3 =4
        int r2 = rob(new int[]{2, 7, 9, 3, 1}); // 2+9+1=12
    }
}
