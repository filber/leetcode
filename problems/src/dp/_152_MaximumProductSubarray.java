package dp;

// https://leetcode.com/problems/maximum-product-subarray/
public class _152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int minDP = nums[0];
        int maxDP = nums[0];
        int result = maxDP;
        for (int i = 1; i < n; i++) {
            int prevMin = minDP;
            int prevMax = maxDP;
            minDP = Math.min(nums[i], Math.min(nums[i] * prevMin, nums[i] * prevMax));
            maxDP = Math.max(nums[i], Math.max(nums[i] * prevMin, nums[i] * prevMax));
            result = Math.max(result, maxDP);
        }
        return result;
    }
}
