package stack;

//https://leetcode.com/problems/create-maximum-number/

public class _321_CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        // if k>n, i can't be zero, must choose some elements from nums1
        // else i could be zero
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] arr = merge(maxArr(nums1, i), maxArr(nums2, k - i), k);
            if (gt(arr, 0, res, 0)) res = arr;
        }
        return res;
    }

    private int[] maxArr(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1;
        for (int i = 0; i < n; i++) {
            // n-i : elements remain not processed in nums
            // top + 1 : stack size
            // n-i+j : potential elements being added to stack
            // if n-i+j<=k, we can't pop
            while (n - i + top + 1 > k && top >= 0 && nums[i] > stack[top]) {
                // keep poping until Ni > Peek
                top--;
            }
            if (top + 1 < k) {
                stack[++top] = nums[i];
            }
        }
        return stack;
    }

    // merge nums1 and nums2
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++)
            if (gt(nums1, i, nums2, j)) {
                res[r] = nums1[i++];
            } else {
                res[r] = nums2[j++];
            }
        return res;
    }

    // True: nums1 >= nums2
    private boolean gt(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        if (j == nums2.length) {
            // j reach the end or i reach the end at same time, nums1 >= nums2
            return true;
        } else if (i == nums1.length) {
            // i reach the end while j didn't, nums1 < nums2
            return false;
        } else {
            // nums1[i] != nums2[j]
            return nums1[i] > nums2[j];
        }

    }
}
