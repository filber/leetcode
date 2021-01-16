public class _53_MaximumSubarray {

  public static int maxSubArray(int[] nums) {
    if (nums.length < 2) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int sum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      // Calculate again or based on previous result
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      sum = Math.max(dp[i],sum);
    }
    return sum;
  }

  public static int maxSubArrayV2(int[] nums) {
    int res = nums[0];
    int sum = 0;
    for (int num : nums) {
      if (sum > 0)
        sum += num;
      else
        sum = num;
      res = Math.max(res, sum);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {-1,-2};
    // 4,-1,2,1
    int max = maxSubArray(nums);

  }

}
