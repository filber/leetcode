package bs;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class _81_SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            // found target!
            if (nums[mid] == target) return true;

            while (l < mid && nums[l] == nums[mid]) {
                l++;
            }
            if (l == mid) {
                l = mid + 1;
                continue;
            }

            // right part in order
            if (nums[mid] <= nums[r]) {
                // target resides in right part
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // left part in order
            else {
                // target resides in left part
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return false;
    }
}
