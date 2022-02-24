package stack;

//https://leetcode.com/problems/create-maximum-number/

public class _321_CreateMaximumNumber {

    /*
假设数组一为[3,4,6,5]、数组二为[9,1,2,5,8,3]、k = 5;
组合情况有0 + 5、1 + 4、2 + 3、3 + 2、4 + 1五种情况,就是从此五种情况取出组合最大的一种;
Math.max(0, k - n)表示若数组二的元素个数 >= k,则数组一的元素个数可以从0开始取,否则在数组二的大小基础上补.
*/
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
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            // n-i : elements remain not processed in nums
            // j : elements already added to res
            // n-i+j : potential elements being added to res
            // if n-i+j<=k, we can't pop
            while (n - i + j > k && j > 0 && nums[i] > res[j - 1]) {
                // keep poping until Ni > Peek
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
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
