package array_matrix;

//https://leetcode.com/problems/first-missing-positive/


public class _41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int idx = 0;
        while (idx < n) {
            int correctIdx = nums[idx] - 1;
            if (nums[idx] > 0 && nums[idx] <= n && nums[correctIdx] != nums[idx]) {
                // swap nums[idx] <-> nums[correctIdx]
                // After moving nums[idx] to its correct position,
                // current nums[idx] might be invalid, so we hold idx
                int tmp = nums[idx];
                nums[idx] = nums[correctIdx];
                nums[correctIdx] = tmp;
            } else {
                idx++;
            }
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
