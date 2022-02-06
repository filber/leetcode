package bs;

// https://leetcode.com/problems/find-in-mountain-array/
public class _1095_FindInMountainArray {

//    Constraints:
//            3 <= mountain_arr.length() <= 10^4
//            0 <= target <= 10^9
//            0 <= mountain_arr.get(index) <= 10^9
    public static class MountainArray {
        private int[] m;

        public MountainArray(int[] m) {
            this.m = m;
        }
        public int get(int index) {
            return m[index];
        }
        public int length() {
            return m.length;
        }
    }

    public static int peakIndexInMountainArray(MountainArray arr) {
        int n = arr.length();
        int l = 0, r = n - 1;
        while (r - l >= 2) {
            int mid = (l + r) / 2;
            int midVal = arr.get(mid);
            int left = arr.get(mid - 1);
            int right = arr.get(mid + 1);
            if (left < midVal && midVal > right) {
                return mid;
            } else if (left < midVal && midVal < right) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    //    return the MINIMUM index of target
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        if (mountainArr.get(peak) == target) {
            return peak; // found
        }

        // search in the left part of the peak
        int l = 0,r = peak;
        while (l <= r) {
            int mid = (l+r)/2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid; // found
            } else if (target < midVal) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // search in the right part of the peak
        l = peak;
        r = mountainArr.length() - 1;
        while (l <= r) {
            int mid = (l+r)/2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid; // found
            } else if (target < midVal) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        int i1 = findInMountainArray(3,
                new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1})); // 2
        int i2 = findInMountainArray(3,
                new MountainArray(new int[]{0, 1, 2, 4, 2, 1})); // -1
        int i3 = findInMountainArray(3,
                new MountainArray(new int[]{-1, 1, 2, 4, 5, 3, 1})); // 5
        int i4 = findInMountainArray(3,
                new MountainArray(new int[]{-1, 1, 2, 4, 5, 3, 1})); // 5
        int i5 = findInMountainArray(2,
                new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1})); // 1
    }
}
