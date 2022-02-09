package array_matrix;

//https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/

import java.util.PriorityQueue;

public class _2040_KthSmallestProductOfTwoSortedArrays {

    private static final long INF = (long) 1e10;
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
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
            long mid = lo + ((hi - lo) >> 1), cnt = 0;
            for (int i : small) {
                if (i >= 0) {
                    int l = 0, r = n - 1, p = 0;
                    while (l <= r) {
                        int c = l + ((r - l) >> 1);
                        long mul = i * (long) large[c];
                        if (mul <= mid) {
                            p = c + 1;
                            l = c + 1;
                        } else {
                            r = c - 1;
                        }
                    }
                    // large[0] ~ large[c] satisfy the criteria
                    // # c+1
                    cnt += p;
                } else {
                    int l = 0, r = n - 1, p = 0;
                    while (l <= r) {
                        int c = l + ((r - l) >> 1);
                        long mul = i * (long) large[c];
                        if (mul <= mid) {
                            p = n - c;
                            r = c - 1;
                        } else {
                            l = c + 1;
                        }
                    }
                    // large[c] ~ large[n-1] satisfy the criteria
                    // # n-c
                    cnt += p;
                }
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

        long k5 = kthSmallestProduct(
                new int[]{-9, 6, 10},
                new int[]{-7, -1, 1, 2, 3, 4, 4, 6, 9, 10},
                15);
    }
}
