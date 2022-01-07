package dp;

// https://leetcode.com/problems/maximum-product-subarray/
public class _152_MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int maxProduct = nums[0];
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            maxProduct = Math.max(dpMax[i], maxProduct);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        // 2,3,-2,4    -   6
        int m1 = maxProduct(new int[]{2, 3, -2, 4});
        // -2,0,-1     -   0
        int m2 = maxProduct(new int[]{-2,0,-1});

        // 2
        int m3 = maxProduct(new int[]{0,2});

        // 24
        int m4 = maxProduct(new int[]{-2, 3, -4});
    }
}
