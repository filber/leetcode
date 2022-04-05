package array_matrix;

//https://leetcode.com/problems/set-mismatch/

public class _645_SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i + 1) {
                continue;
            }

            int to = nums[i];
            while (to != nums[to - 1]) {
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
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[0];
    }
}
