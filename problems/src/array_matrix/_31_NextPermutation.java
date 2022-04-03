package array_matrix;

//https://leetcode.com/problems/next-permutation/

import java.util.Arrays;

public class _31_NextPermutation {

    int[] nums;
    int n;

    public void nextPermutation(int[] nums) {
        n = nums.length;
        this.nums = nums;
        int i = n - 1;
        for (; i > 0 && nums[i - 1] >= nums[i]; i--) {
        }

        Arrays.sort(nums, i, n);
        if (i != 0) {
            int j = search(i, n - 1, nums[i - 1]);
            // swap
            int tmp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = tmp;
        }
    }

    // find first Nj > T
    public int search(int l, int r, int T) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= T) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
