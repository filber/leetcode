package array_matrix;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

import java.util.Arrays;

public class _462_MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int target = nums[n / 2];
        int sum = 0;
        for (int val : nums) {
            sum += Math.abs(val - target);
        }
        return sum;
    }
}
