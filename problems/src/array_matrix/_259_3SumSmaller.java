package array_matrix;

//https://leetcode.com/problems/3sum-smaller

import java.lang.reflect.Array;
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

    int[] nums;

    public int threeSumSmaller(int[] nums, int target) {
        this.nums = nums;
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            cnt += twoSumSmaller(i + 1, n - 1, target - nums[i]);
        }

        return cnt;
    }

    public int twoSumSmaller(int l, int r, int target) {
        int cnt = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum >= target) {
                r--;
            } else {
                cnt += r - l;
                l++;
            }
        }

        return cnt;
    }
}
