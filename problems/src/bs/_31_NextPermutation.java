package bs;

//https://leetcode.com/problems/next-permutation/

import java.util.Arrays;

public class _31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        Arrays.sort(nums, i, n);

        if (i != 0) {
            int l = i;
            int r = n - 1;
            int target = nums[i - 1];
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int tmp = nums[i - 1];
            nums[i - 1] = nums[l];
            nums[l] = tmp;
        }
    }
}
