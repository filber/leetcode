package bs;

//https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/

public class _1508_RangeSumOfSortedSubarraySums {

    private int[] A;
    private int totalSum = 0;
    private final int M = (int) 1e9 + 7;

    public int rangeSum(int[] A, int n, int left, int right) {
        totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }
        this.A = A;

        return (int) ((sumK(right) - sumK(left - 1)) % M);
    }

    private long sumK(int k) {
        if (k < 1) {
            return 0L;
        }
        int l = 1, r = totalSum;
        long[] count;
        while (l < r) {
            int mid = l + (r - l) / 2;
            count = countK(A, mid);
            if (count[0] >= k) {
                r = mid; // mid is too large
            } else {
                l = mid + 1; // mid is too small
            }
        }
        count = countK(A, l);
        // count could be larger than k
        // 1,2,2,[2,2,2]
        // k = 3, count = 6
        return count[1] - l * (count[0] - k);
    }

    // found count and sums <= target
    public long[] countK(int[] A, int target) {
        long curWinSum = 0;
        long curWinSubArraySum = 0;
        long totalSum = 0;
        long totalCnt = 0;
        int l = 0;
        for (int r = 0; r < A.length; r++) {
            curWinSum += A[r];
            curWinSubArraySum += (long) (r - l + 1) * A[r];
            while (curWinSum > target) {
                curWinSubArraySum -= curWinSum;
                curWinSum -= A[l];
                l++;
            }
            totalSum += curWinSubArraySum;
            totalCnt += r - l + 1;
        }

        return new long[]{totalCnt, totalSum};
    }
}
