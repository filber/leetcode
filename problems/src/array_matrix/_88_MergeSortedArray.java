package array_matrix;

//https://leetcode.com/problems/merge-sorted-array/

public class _88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int l = m - 1, r = n - 1;
        int idx = m + n - 1;
        while (l >= 0 && r >= 0) {
            int L = nums1[l], R = nums2[r];
            if (L >= R) {
                nums1[idx--] = nums1[l--];
            } else {
                nums1[idx--] = nums2[r--];
            }
        }

        while (r >= 0) {
            nums1[idx--] = nums2[r--];
        }
    }

}