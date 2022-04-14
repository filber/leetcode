package bs;

//https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/

public class _EX_BitonicArrayMaximum {

//    Given an array of integers which is initially increasing and then decreasing,
//    find the maximum value in the array.

    int[] arr;

    public int findMaximum(int arr[]) {
        this.arr = arr;
        if (arr.length == 1) {
            return arr[0];
        }
        return search(0, arr.length - 1);
    }

    private int search(int l, int r) {
        int mid = (l + r) / 2;
        if (mid == 0) {
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else {
                return search(mid + 1, r);
            }
        } else if (mid == arr.length - 1) {
            if (arr[mid - 1] < arr[mid]) {
                return arr[mid];
            } else {
                return search(l, mid - 1);
            }
        } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return arr[mid];
        } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            return search(mid + 1, r);
        } else {
            return search(l, mid - 1);
        }
    }
}
