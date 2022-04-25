package bs;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

public class _154_FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mVal = nums[mid];
            min = Math.min(min, mVal);

            while (l < mid && nums[l] == mVal) {
                l++;
            }
            if (l == mid) {
                l = mid + 1;
                continue;
            }
            while (mid < r && nums[r] == mVal) {
                r--;
            }
            if (r == mid) {
                r = mid - 1;
                continue;
            }

            if (nums[l] < mVal) {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
        }

        return min;
    }
}
