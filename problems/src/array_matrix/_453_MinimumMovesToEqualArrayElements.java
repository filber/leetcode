package array_matrix;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

public class _453_MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int val : nums) {
            if (val < min) {
                min = val;
            }
        }

        int sum = 0;
        for (int val : nums) {
            sum += val - min;
        }
        return sum;
    }
}
