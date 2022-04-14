package bs;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class _153_FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = nums[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] <= nums[mid]) {
                // left part in order
                min = Math.min(min, nums[l]);
                l = mid + 1;
            } else {
                // right part in order
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
        }
        return min;
    }
}