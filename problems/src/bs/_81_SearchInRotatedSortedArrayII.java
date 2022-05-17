package bs;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class _81_SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            while (nums[l] == nums[mid] && l < mid) {
                l++;
            }
            while (nums[r]  == nums[mid] && mid < r) {
                r--;
            }
            if (l == mid) {
                l++;
                continue;
            } else if (r == mid) {
                r--;
                continue;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }

        return false;
    }
}
