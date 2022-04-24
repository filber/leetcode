package bs;

//https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
public class _EX_CeilingInASortedArray {

    // ceil: greater than or equal to x
    public int ceilSearch(int[] arr, int x) {
        if (x > arr[arr.length - 1]) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l];
    }
}
