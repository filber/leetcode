package array_matrix;

//https://leetcode.com/problems/first-missing-positive/


public class _41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n || nums[i] == i + 1) {
                continue;
            }

            int to = nums[i];
            while (to > 0 && to <= n && to != nums[to - 1]) {
                int tmp = nums[to - 1];
                nums[to - 1] = to;
                to = tmp;
            }

            if (nums[i] != i + 1) {
                nums[i] = to;
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
