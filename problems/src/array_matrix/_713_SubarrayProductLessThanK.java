package array_matrix;

//https://leetcode.com/problems/subarray-product-less-than-k/

public class _713_SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int n = nums.length;
        int prod = 1, ans = 0, l = 0, r = 0;
        while (r < n) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l];
                l++;
            }
            r++;
            ans += r - l;
        }
        return ans;
    }

}
