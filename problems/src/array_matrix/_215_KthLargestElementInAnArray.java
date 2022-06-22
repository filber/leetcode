package array_matrix;
//https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.Arrays;

public class _215_KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }
}
