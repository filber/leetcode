package array_matrix;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class _80_RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            int val = nums[fast];
            if (fast < 2 || nums[slow - 2] != val) {
                nums[slow] = val;
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 1, 1, 2, 2, 3};
        int c1 = removeDuplicates(n1);

        int[] n2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int c2 = removeDuplicates(n2);
    }
}
