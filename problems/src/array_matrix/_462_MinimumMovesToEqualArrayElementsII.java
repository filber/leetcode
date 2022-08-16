package array_matrix;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

import java.util.Arrays;

public class _462_MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
