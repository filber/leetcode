package bs;

//https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
public class _EX_CeilingInASortedArray {

    int[] arr;
    int x;

    // ceil: greater than or equal to x
    public int ceilSearch(int[] arr, int x) {
        this.arr = arr;
        this.x = x;
        return search(0, arr.length - 1);
    }

    private int search(int l, int r) {
        if (l > r) {
            return -1;
        } else if (l == r) {
            if (x <= arr[l]) {
                return arr[l];
            } else {
                return -1;
            }
        } else {
            int mid = (l + r) / 2;
            if (x <= arr[mid]) {
                return search(l, mid);
            } else {
                return search(mid + 1, r);
            }
        }
    }
}
