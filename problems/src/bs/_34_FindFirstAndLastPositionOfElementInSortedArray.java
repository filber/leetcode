package bs;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    int[] nums;
    int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int[] notFound = new int[]{-1, -1};
        int first = searchFirst();
        if (first == -1) {
            return notFound;
        }
        int last = searchLast();
        return new int[]{first, last};
    }

    private int searchFirst() {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (0 <= l && l < nums.length && nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }

    private int searchLast() {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (0 <= l && l < nums.length && nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}
