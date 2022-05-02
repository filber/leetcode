package array_matrix;

//https://leetcode.com/problems/sort-array-by-parity/

public class _905_SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 0 && nums[r] % 2 != 0) {
                l++;
                r--;
            } else if (nums[l] % 2 != 0 && nums[r] % 2 == 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            } else if (nums[l] % 2 == 0) {
                l++;
            } else if (nums[r] % 2 != 0) {
                r--;
            }
        }

        return nums;
    }
}
