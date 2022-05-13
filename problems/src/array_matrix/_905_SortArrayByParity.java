package array_matrix;

//https://leetcode.com/problems/sort-array-by-parity/

public class _905_SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            boolean leftEven = nums[l] % 2 == 0;
            boolean leftOdd = !leftEven;
            boolean rightEven = nums[r] % 2 == 0;
            boolean rightOdd = !rightEven;
            if (leftOdd && rightEven) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            } else if (leftOdd && rightOdd) {
                r--;
            } else if (leftEven && rightOdd) {
                l++;
                r--;
            } else if (leftEven && rightEven) {
                l++;
            }
        }
        return nums;
    }
}
