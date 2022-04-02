package array_matrix;

//https://leetcode.com/problems/subarray-product-less-than-k/

public class _713_SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int n = nums.length;
        int l = 0, r = 0;
        int cnt = 0, product = 1;
        while (r < n) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }
            cnt += r - l + 1;
            r++;
        }

        return cnt;
    }

}
