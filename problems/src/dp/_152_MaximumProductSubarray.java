package dp;

// https://leetcode.com/problems/maximum-product-subarray/
public class _152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxProduct = new int[n];
        maxProduct[0] = nums[0];
        int[] minProduct = new int[n];
        minProduct[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int val = nums[i];
            int maxP = maxProduct[i - 1] * val;
            int minP = minProduct[i - 1] * val;
            maxProduct[i] = Math.max(val, Math.max(maxP, minP));
            minProduct[i] = Math.min(val, Math.min(maxP, minP));
            max = Math.max(max, maxProduct[i]);
        }

        return max;
    }
}
