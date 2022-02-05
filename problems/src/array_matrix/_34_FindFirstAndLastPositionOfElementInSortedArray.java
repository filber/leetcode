package array_matrix;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class _34_FindFirstAndLastPositionOfElementInSortedArray {

//  Constraints:
//          0 <= nums.length <= 10^5
//          -10^9 <= nums[i] <= 10^9
//          nums is a non-decreasing array.
//          -10^9 <= target <= 10^9

    public static int[] searchRange(int[] nums, int target) {
        int idx = bs(nums, target);
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        int fIdx = searchFirst(nums, target, 0, idx);
        int lIdx = searchLast(nums, target, idx, nums.length - 1);
        return new int[]{fIdx, lIdx};
    }

    private static int searchFirst(int[] nums, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int searchLast(int[] nums, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end + 1) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private static int bs(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midVal = nums[mid];
            if (target == midVal) {
                return mid;
            } else if (target > midVal) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // [3,4]
        int[] p1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        // [-1,-1]
        int[] p2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        // [-1,-1]
        int[] p3 = searchRange(new int[]{}, 0);
        // [1,4]
        int[] p4 = searchRange(new int[]{5, 7, 7, 7, 7, 8, 8, 10}, 7);
    }
}
