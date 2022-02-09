package array_matrix;

//https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/


public class _2040_KthSmallestProductOfTwoSortedArrays {

    private static final long INF = (long) 1e10;

    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        //split array into neg and pos, neg reverse order and make pos
        int[][] A = splitArray(nums1);
        int[][] B = splitArray(nums2);
        //check k vs neg_num, change sign
        long numNeg = A[0].length * 1L * B[1].length + A[1].length * 1L * B[0].length;
        long low = (long) -INF - 1, high = (long) INF + 1, mid;
        if(k <= numNeg){
            // only look for negative numbers
            while(low < high) {
                mid = low + ((high - low) >> 1);
                long cnt1 = count(A[0], 0,1, B[1], 0, 1, mid);
                long cnt2 = count(A[1], A[1].length - 1, -1, B[0], B[0].length - 1, -1, mid);
                if (cnt1 + cnt2 >= k) {
                    high = mid;
                } else {
                    low = mid + 1L;
                }
            }
        } else {
            // only look for positive numbers
            // ignore all negative ones
            k -= numNeg;
            while(low < high){
                mid = low + ((high - low) >> 1);
                long cnt1 = count(A[0],A[0].length-1,-1, B[0], 0, 1, mid);
                long cnt2 = count(A[1], 0, 1,B[1], B[1].length - 1, -1, mid);
                if (cnt1 + cnt2 >= k) {
                    high = mid;
                } else {
                    low = mid + 1L;
                }
            }
        }

        return low;
    }

    //return num of prod <= val
    private static long count(int[] A,int aStart, int aDir, int[] B, int bStart, int bDir, long val) {
        long res = 0;
        int n = B.length;
        int idx = bStart;
        for (int i = aStart; i >= 0 && i < A.length; i += aDir) {
            int a = A[i];
            while (idx >= 0 && idx <= n - 1 && a * 1L * B[idx] > val) idx += bDir;
            if (bDir > 0) {
                res += n - idx;
            } else {
                res += idx + 1;
            }
        }
        return res;
    }

    private static int[][] splitArray(int[] A) {
        //get idx of first postive
        int idx = getLeftMostGreaterEq(A, 0);
        int[][] res = new int[2][];
        res[0] = new int[idx];
        for (int i = 0; i < idx; i++) res[0][i] = A[i];
        res[1] = new int[A.length - idx];
        for (int i = idx; i < A.length; i++) res[1][i - idx] = A[i];
        return res;
    }

    private static int getLeftMostGreaterEq(int[] A, int val){
        int l = 0, r = A.length-1;
        if(A[r] < val) return A.length;
        int mid = 0;
        while(l < r){
            mid = l + (r - l) / 2;
            if(A[mid] >= val){
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static long kthSmallestProductV1(int[] nums1, int[] nums2, long k) {
        int[] small;
        int[] large;
        if (nums1.length < nums2.length) {
            small = nums1;
            large = nums2;
        } else {
            small = nums2;
            large = nums1;
        }
        int n = large.length;
        long lo = -INF - 1, hi = INF + 1;

        while (lo < hi) {
            long cnt = 0;
            long mid = lo + ((hi - lo) >> 1);
            for (int i : small) {
                int l = 0, r = n - 1;
                int p = 0;
                if (i >= 0) {
                    while (l <= r) {
                        int c = l + ((r - l) >> 1);
                        long mul = i * (long) large[c];
                        if (mul <= mid) {
                            // mul should be larger, move l to right
                            p = c + 1; // large[0]~large[c] satisfy the criteria
                            l = c + 1;
                        } else {
                            r = c - 1;
                        }
                    }
                } else {
                    while (l <= r) {
                        int c = l + ((r - l) >> 1);
                        long mul = i * (long) large[c];
                        if (mul <= mid) {
                            // mul should be larger, move r to left
                            p = n - c; // large[c]~large[n-1] satisfy the criteria
                            r = c - 1;
                        } else {
                            l = c + 1;
                        }
                    }
                }
                cnt += p;
            }

            if (cnt >= k) {
                hi = mid;
            } else {
                lo = mid + 1L;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        // -6
        long k1 = kthSmallestProduct(
                new int[]{-2, -1, 0, 1, 2},
                new int[]{-3, -1, 2, 4, 5},
                3);

        // 0
        long k2 = kthSmallestProduct(
                new int[]{-4, -2, 0, 3},
                new int[]{2, 4},
                6);

        // 8
        long k3 = kthSmallestProduct(
                new int[]{2, 5},
                new int[]{3, 4},
                2);

        // -10000000000
        long k4 = kthSmallestProduct(
                new int[]{-100000, 100000},
                new int[]{-100000, 100000},
                1);

        // 10
        long k5 = kthSmallestProduct(
                new int[]{-9, 6, 10},
                new int[]{-7, -1, 1, 2, 3, 4, 4, 6, 9, 10},
                15);

        // -9
        long k6 = kthSmallestProduct(
                new int[]{3},
                new int[]{-3},
                1);
    }
}
