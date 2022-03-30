package array_matrix;

//https://leetcode.com/problems/3sum-smaller

import java.util.Arrays;

public class _259_3SumSmaller {

//    Given an array of n integers nums and a target,
//    find the number of index triplets i, j, k with 0 <= i < j < k < n
//    that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//
//    For example, given nums = [-2, 0, 1, 3], and target = 2.
//    Return 2. Because there are two triplets which sums are less than 2:
//            [-2, 0, 1]
//            [-2, 0, 3]

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int[] tmp = Arrays.copyOfRange(nums, i + 1, n);
            sum += twoSumSmaller(tmp, target - nums[i]);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int sum = 0;
        while (l < r) {
            int lVal = nums[l];
            int rVal = nums[r];
            if (lVal + rVal >= target) {
                r--;
            } else {
                sum += r - l;
                l++;
            }
        }
        return sum;
    }
}
