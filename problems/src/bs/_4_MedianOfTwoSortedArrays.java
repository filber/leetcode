package bs;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class _4_MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int leftIdx = (m + n + 1) / 2;
        int rightIdx = (m + n + 2) / 2;
        int leftVal = findKth(A, 0, B, 0, leftIdx);
        int rightVal = findKth(A, 0, B, 0, rightIdx);
        return (leftVal + rightVal) / 2.0;
    }

    // find Kth Smallest Element in A&B
    private static int findKth(int[] A, int i, int[] B, int j, int k) {
        if (i == A.length) {
            return B[j + k - 1];
        }
        if (j == B.length) {
            return A[i + k - 1];
        }
        if (k == 1) {
            return Math.min(A[i], B[j]);
        }

        int midAIdx = i + k / 2 - 1;
        int midA = midAIdx < A.length ? A[midAIdx] : Integer.MAX_VALUE;
        int midBIdx = j + k / 2 - 1;
        int midB = midBIdx < B.length ? B[midBIdx] : Integer.MAX_VALUE;
        if (midA < midB) {
            return findKth(A, i + k / 2, B, j, (k + 1) / 2);
        } else {
            return findKth(A, i, B, j + k / 2, (k + 1) / 2);
        }
    }

    public static void main(String[] args) {
        double m1 = findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2});
        double m2 = findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{2, 4});
        double m3 = findMedianSortedArrays(
                new int[]{1, 2, 3},
                new int[]{3, 4, 5});
        double m4 = findMedianSortedArrays(
                new int[]{1, 2, 3, 4},
                new int[]{5, 6});
    }
}
