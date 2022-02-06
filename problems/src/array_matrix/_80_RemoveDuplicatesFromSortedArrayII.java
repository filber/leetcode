package array_matrix;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class _80_RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i] || (j == 0 || nums[j - 1] != nums[i])) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 1, 1, 2, 2, 3};
        int c1 = removeDuplicates(n1);

        int[] n2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int c2 = removeDuplicates(n2);
    }
}
