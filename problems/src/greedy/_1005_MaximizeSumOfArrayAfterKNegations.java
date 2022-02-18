package greedy;

// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

import java.util.Arrays;

public class _1005_MaximizeSumOfArrayAfterKNegations {

    //  Constraint:
    //      1 <= A.length <= 10000
    //      1 <= K <= 10000
    //      -100 <= A[i] <= 100
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (k != 0) {
                if (nums[i] == 0) {
                    // consuming all negations
                    k = 0;
                } else if (nums[i] > 0) {
                    // double negations take no effect
                    if (k % 2 != 0) {
                        // before Ni, we have no zero, otherwise all negations would be consumed
                        if (i == 0) {
                            // Ni is the first positive number
                            nums[i] = -nums[i];
                        } else {
                            // before Ni is the biggest negative numbers, which has already been negated
                            if (nums[i] > nums[i - 1]) {
                                sum -= 2 * nums[i - 1]; // counter effect
                            } else {
                                nums[i] = -nums[i];
                            }
                        }
                        // consume all negations
                    }
                    k = 0;
                } else {
                    // nums[i] < 0
                    nums[i] = -nums[i];
                    k--;
                }
            }

            sum += nums[i];
        }

        if (k % 2 != 0) {
            // all numbers are negative, still need some more negations
            sum -= 2 * nums[n - 1];
        }

        return sum;
    }
}
