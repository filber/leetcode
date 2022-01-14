package array_matrix;

// https://leetcode.com/problems/longest-increasing-subsequence/

public class _300_LongestIncreasingSubsequence {

    // O(N*logN)
    public static int lengthOfLIS(int[] nums) {
        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            int insertLocation = binarySearch(dp, num, 0, maxL);
            dp[insertLocation] = num;
            if (insertLocation == maxL)
                maxL++;
        }
        return maxL;
    }


    private static int binarySearch(int[] dp, int num, int l, int r) {
        while (l < r) {
            int mid = (r + l) / 2;
            int midVal = dp[mid];
            if (midVal < num)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }


    // O(N*N)
    public static int lengthOfLISV1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {

        int l4 = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 1, 101, 18});

        // 4 - [2,3,7,101]
        int l1 = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        // 4 - [0,1,2,3]
        int l2 = lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        // 1 - [7]
        int l3 = lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
    }
}
