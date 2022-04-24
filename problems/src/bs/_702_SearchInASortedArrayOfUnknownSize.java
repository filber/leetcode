package bs;

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

public class _702_SearchInASortedArrayOfUnknownSize {

//    Given an integer array sorted in ascending order,
//    write a function to search target in nums.
//    If target exists, then return its index,
//    otherwise return -1.
//    However, the array size is unknown to you.
//    You may only access the array using an ArrayReader interface,
//    where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

//    You may assume all integers in the array are less than 10000,
//    and if you access the array out of bounds, ArrayReader.get will return 2147483647.
//    The value of each element in the array will be in the range [-9999, 9999].

    public static class ArrayReader {
        int[] nums;

        public ArrayReader(int[] nums) {
            this.nums = nums;
        }

        int get(int idx) {
            if (idx < 0 || idx >= nums.length) {
                return Integer.MAX_VALUE;
            } else {
                return nums[idx];
            }
        }
    }

    public int searchUnknownSize(ArrayReader ar, int val) {
        int l = 0, r = 20000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mVal = ar.get(mid);
            if (mVal == Integer.MAX_VALUE) {
                r = mid - 1;
            } else if (mVal == val) {
                return mid;
            } else if (mVal < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
