package array_matrix;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class _26_RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 1, 2};
        int c1 = removeDuplicates(n1);

        int[] n2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int c2 = removeDuplicates(n2);

        int[] n3 = new int[]{1, 2, 3, 4};
        int c3 = removeDuplicates(n3);

        int[] n4 = new int[]{1, 1};
        int c4 = removeDuplicates(n4);

        int[] n5 = new int[]{1};
        int c5 = removeDuplicates(n5);
    }
}
