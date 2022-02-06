package bs;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class _852_PeakIndexInAMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (r - l >= 2) {
            int mid = (l + r) / 2;
            int midVal = arr[mid];
            int left = arr[mid - 1];
            int right = arr[mid + 1];
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
    public static void main(String[] args) {
        int i1 = peakIndexInMountainArray(new int[]{0, 1, 0}); // 1
        int i2 = peakIndexInMountainArray(new int[]{0, 2, 1, 0}); // 1
        int i3 = peakIndexInMountainArray(new int[]{0, 10, 5, 2}); // 1
        int i4 = peakIndexInMountainArray(new int[]{3, 4, 5, 1}); // 2
        int i5 = peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}); // 2
    }
}
