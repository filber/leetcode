package array_matrix;

// https://leetcode.com/problems/non-decreasing-array/
public class _665_NonDecreasingArray {
    public static boolean checkPossibility(int[] nums) {
        int id1 = checkPossibility(nums, 0, nums.length - 2);
        if (id1 == -1) {
            return true;
        }

        if (id1 == 0) {
            nums[id1] = nums[id1 + 1];
        } else if (nums[id1 - 1] <= nums[id1 + 1]) {
            // ... 1,4,3...
            // ... 1,1,3...
            nums[id1] = nums[id1 - 1];
        } else {
            // ... 3,4,4...
            nums[id1+1] = nums[id1];
        }

        int id2 = checkPossibility(nums, id1, nums.length - 2);
        if (id2 == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static int checkPossibility(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean b1 = checkPossibility(new int[]{4, 2, 3}); // true
        boolean b2 = checkPossibility(new int[]{4, 2, 1}); // false
        boolean b3 = checkPossibility(new int[]{3, 4, 2, 3}); // false
        boolean b4 = checkPossibility(new int[]{5, 7, 1, 8}); // true
    }
}
