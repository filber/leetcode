package bs;

//https://leetcode.com/problems/k-th-smallest-prime-fraction/

public class _786_KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double start = 0, end = 1;
        while (start + 1e-9 < end) {
            double mid = start + (end - start) / 2;
            int count = 0;
            int p = 0, q = 1;
            int j = 1;
            for (int i = 0; i < n - 1 && j < n; i++) {
                // keep moving j until arr[i]/arr[j] <= mid
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                // for dominators after j, they are make fractions <= F
                count += (n - j);
                // constraint: arr[i]/arr[j] <= mid
                // arr[i]/arr[j] > p/q => it's closer to mid
                if (j < n && arr[i] * q > p * arr[j]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (count == k) {
                return new int[]{p, q};
            } else if (count > k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return new int[]{-1, -1};
    }
}
