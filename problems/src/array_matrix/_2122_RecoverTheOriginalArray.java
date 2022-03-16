package array_matrix;

import java.util.Arrays;

public class _2122_RecoverTheOriginalArray {

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length / 2];
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[0];
            // diff not tried before
            // diff is an even number larger than 0
            // diff/2 is a valid k for array
            if (diff != prev && diff > 0 && diff % 2 == 0 && check(nums, i, diff / 2, res))
                break;
            prev = diff;
        }
        return res;
    }

    private boolean check(int[] nums, int j, int k, int[] res) {
        int idx = 0;
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int target = nums[i] + 2 * k;

            // try to find target not visited
            while (j < nums.length && (nums[j] < target || (nums[j] == target && visited[j]))) {
                j++;
            }
            if (j == nums.length || nums[j] != target) {
                return false; // target not found!
            }
            visited[j] = true;
            res[idx++] = nums[i] + k;
        }
        return true;
    }
}
