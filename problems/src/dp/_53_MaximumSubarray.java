package dp;// TOPICS:
// [Dynamic Programming]

// https://leetcode.com/problems/maximum-subarray/
// dp[i] = max(dp[i-1]+n[i],n[i]) , dp[i] represent maxSum of sub-arrays ending with i
// maxSum = max(dp[i],maxSum)
public class _53_MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int sum = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            sum = Math.max(dp[i],sum);
        }

        return sum;
    }

    public static int maxSubArray2(int[] nums) {
      if (nums.length < 2) {
        return nums[0];
      }

      int sum = 0;
      int res = nums[0];

      for (int num : nums) {
        if (sum>0) {
          sum += num;
        } else {
          sum = num;
        }
        res = Math.max(sum,res);
      }

      return res;
    }


    public static void main(String[] args) {
        int m1 = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}); // 6
        int m2 = maxSubArray(new int[]{1}); // 1
        int m3 = maxSubArray(new int[]{5,4,-1,7,8}); // 23
    }

}