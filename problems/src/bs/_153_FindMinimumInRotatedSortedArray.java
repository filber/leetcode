package bs;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class _153_FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mVal = nums[mid];
            if (nums[l] <= mVal) {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            } else {
                min = Math.min(min, mVal);
                r = mid - 1;
            }
        }
        return min;
    }
}