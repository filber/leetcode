package bs;

//https://www.geeksforgeeks.org/find-element-bitonic-array/

public class _EX_FindAnElementInBitonicArray {

    public int findInArray(int arr[], int val) {
        int l = 0, r = arr.length - 1;
        int peakIdx = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int mVal = arr[mid];
            boolean gtLeft = mid == 0 || arr[mid - 1] < mVal;
            boolean gtRight = mid == arr.length - 1 || mVal > arr[mid + 1];
            if (gtLeft && gtRight) {
                peakIdx = mid;
                break;
            } else if (gtLeft) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (peakIdx == -1) {
            peakIdx = l;
        }
        if (arr[peakIdx] < val) {
            return -1;
        } else if (val < arr[0] && val < arr[arr.length - 1]) {
            return -1;
        } else if (val < arr[arr.length - 1]) {
            return bs(arr, 0, peakIdx, val, true);
        } else if (val < arr[0]) {
            return bs(arr, peakIdx, arr.length - 1, val, false);
        }

        int idx = bs(arr, 0, peakIdx, val, true);
        if (idx != -1) {
            return idx;
        }
        idx = bs(arr, peakIdx, arr.length - 1, val, false);
        return idx;
    }

    int bs(int[] arr, int l, int r, int val, boolean asc) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mVal = arr[mid];
            if (mVal == val) {
                return mid;
            } else if (mVal < val) {
                if (asc) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (asc) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
