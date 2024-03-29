package tp;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class _26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
}
