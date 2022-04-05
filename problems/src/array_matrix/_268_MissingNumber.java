package array_matrix;

//https://leetcode.com/problems/missing-number/

public class _268_MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                continue;
            }

            int to = nums[i];
            while (to < n && to != nums[to]) {
                int tmp = nums[to];
                nums[to] = to;
                to = tmp;
            }

            if (nums[i] != i) {
                missing = i;
            }
        }

        return missing;
    }
}
