package bs;

//https://www.geeksforgeeks.org/find-element-bitonic-array/

public class _EX_FindAnElementInBitonicArray {

    int[] arr;
    int val;

    public int findInArray(int arr[], int val) {
        int n = arr.length;
        this.arr = arr;
        this.val = val;
        if (n == 1) {
            if (arr[0] == val) {
                return 0;
            } else {
                return -1;
            }
        }

        int peakIdx = findPeak(0, n - 1);
        if (arr[peakIdx] < val) {
            return -1;
        } else if (arr[peakIdx] == val) {
            return peakIdx;
        } else {
            int incIdx = searchVal(0, peakIdx - 1, true);
            if (incIdx == -1) {
                int decIdx = searchVal(peakIdx + 1, n - 1, false);
                return decIdx;
            } else {
                return incIdx;
            }
        }
    }

    private int searchVal(int l, int r, boolean increasing) {
        if (l > r) {
            return -1;
        } else if (l == r) {
            if (arr[l] == val) {
                return l;
            } else {
                return -1;
            }
        } else {
            int mid = (l + r) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (increasing) {
                if (arr[mid] < val) {
                    return searchVal(mid + 1, r, true);
                } else {
                    return searchVal(l, mid - 1, true);
                }
            } else {
                if (arr[mid] < val) {
                    return searchVal(l, mid - 1, false);
                } else {
                    return searchVal(mid + 1, r, false);
                }
            }
        }
    }

    private int findPeak(int l, int r) {
        int mid = (l + r) / 2;
        if (mid == 0) {
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            } else {
                return findPeak(mid + 1, r);
            }
        } else if (mid == arr.length - 1) {
            if (arr[mid - 1] < arr[mid]) {
                return mid;
            } else {
                return findPeak(l, mid - 1);
            }
        } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            return findPeak(mid + 1, r);
        } else {
            return findPeak(l, mid - 1);
        }
    }
}
