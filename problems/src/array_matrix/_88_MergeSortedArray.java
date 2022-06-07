package array_matrix;

//https://leetcode.com/problems/merge-sorted-array/

public class _88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m % nums1.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[idx] = nums1[i++];
            } else {
                nums1[idx] = nums2[j++];
            }
            idx = (idx + 1) % nums1.length;
        }

        while (i < m) {
            nums1[idx] = nums1[i++];
            idx = (idx + 1) % nums1.length;
        }
        while (j < n) {
            nums1[idx] = nums2[j++];
            idx = (idx + 1) % nums1.length;
        }

        // reverse nums1
        reverse(nums1, 0, m + n - 1);
        // reverse first n elements
        reverse(nums1, 0, n - 1);
        // reverse last m elements
        reverse(nums1, n, m + n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}