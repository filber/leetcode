package bs;

//https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/

public class _EX_BitonicArrayMaximum {

//    Given an array of integers which is initially increasing and then decreasing,
//    find the maximum value in the array.

    public int findMaximum(int arr[]) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int mVal = arr[mid];
            boolean gtLeft = mid == 0 || arr[mid - 1] < mVal;
            boolean gtRight = mid == arr.length - 1 || mVal > arr[mid + 1];
            if (gtLeft && gtRight) {
                return arr[mid];
            } else if (gtLeft) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return arr[l];
    }

}
