package array_matrix;

// https://leetcode.com/problems/longest-increasing-subsequence/

public class _300_LongestIncreasingSubsequence {

//    Constraints:
//            1 <= nums.length <= 2500
//            -104 <= nums[i] <= 104

    // O(N*logN)
    public static int lengthOfLIS(int[] nums) {
        int maxL = 0;
        // temp stores the increasing elements less than Ni
        int[] temp = new int[nums.length];
        for (int num : nums) {
            int insertLocation = binarySearch(temp, num, 0, maxL);
            temp[insertLocation] = num;
            if (insertLocation == maxL)
                maxL++;
        }
        return maxL;
    }


    private static int binarySearch(int[] dp, int num, int l, int r) {
        while (l < r) {
            int mid = (r + l) / 2;
            int midVal = dp[mid];
            if (midVal >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
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
