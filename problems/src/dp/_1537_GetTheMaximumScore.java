package dp;

//https://leetcode.com/problems/get-the-maximum-score/

public class _1537_GetTheMaximumScore {

    public int maxSum(int[] nums1, int[] nums2) {
        int modulo = (int) 1e9 + 7;
        int m = nums1.length;
        int n = nums2.length;
        int l = 0, r = 0;
        long dp1 = 0, dp2 = 0;
        while (l < m && r < n) {
            if (nums1[l] < nums2[r]) {
                dp1 += nums1[l++];
            } else if (nums1[l] > nums2[r]) {
                dp2 += nums2[r++];
            } else {
                long max = Math.max(dp1, dp2) + nums1[l];
                dp1 = max;
                dp2 = max;
                l++;
                r++;
            }
        }

        while (l < m) {
            dp1 += nums1[l++];
        }
        while (r < n) {
            dp2 += nums2[r++];
        }

        return (int) (Math.max(dp1, dp2) % modulo);
    }
}
