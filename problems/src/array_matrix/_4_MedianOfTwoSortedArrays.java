package array_matrix;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class _4_MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    // find Kth Smallest Element in A&B
    public static int findKth(int[] A, int i, int[] B, int j, int k){
        // Beyond A's range, skip it all
        if( i >= A.length) {
            return B[j + k - 1];
        }
        // Beyond B's range, skip it all
        if( j >= B.length){
            return A[i + k - 1];
        }
        // Return the smaller first element
        if (k == 1) {
            return Math.min(A[i], B[j]);
        }


        // Find k/2 separately in each array
        // If one Array didn't contain enough elements,
        // we drop first 2/k elements of other the Array.
        int midA = (i + k / 2 - 1 < A.length) ? A[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midB = (j + k / 2 - 1 < B.length) ? B[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midA < midB){
            // k/2 of A is smaller, we drop the first 2/k elements of A.
            // continue to search the rest k/2 elements.
            // ensure k won't be 0
            return findKth(A, i + k / 2, B, j , k - k / 2);
        }else{
            // k/2 of A is smaller, we drop the first 2/k elements of A.
            return findKth(A, i, B, j + k / 2 , k - k / 2);
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
