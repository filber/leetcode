package array_matrix;

// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/

public class _1671_MinimumNumberOfRemovalsToMakeMountainArray {

    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // dpl[i] - LIS ending with i
        int[] dpl = LISIterate(nums, 0, n, 1);
        // dpl[i] - LIS starting with i
        int[] dpr = LISIterate(nums, n - 1, -1, -1);

        int res = 0;
        for (int i = 1; i < n - 1; ++i) {
            // on left side or right side can't find greater than N[i]
            if (dpl[i] <= 1 || dpr[i] <= 1) {
                continue;
            }
            res = Math.max(res, dpl[i] + dpr[i] - 1);
        }
        return n - res;
    }


    private static int[] LISIterate(int[] nums, int begin, int end, int dir) {
        int n = nums.length;
        int[] temp = new int[n];
        int[] dp = new int[n];

        int maxLen = 0;
        int insertLocation;
        for (int i = begin; i != end; i += dir) {
            insertLocation = binarySearch(temp, 0, maxLen, nums[i]);
            dp[i] = insertLocation + 1;

            temp[insertLocation] = nums[i];
            if (insertLocation == maxLen) {
                maxLen++;
            }
        }
        return dp;
    }

    private static int binarySearch(int[] arr, int l, int r, int x) {
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        // 0
        int m1 = minimumMountainRemovals(new int[]{1, 3, 1});

        // 3
        int m2 = minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1});

        // 1
        int m3 = minimumMountainRemovals(new int[]{1, 2, 3, 4, 4, 3, 2, 1});

        // 6
        int m4 = minimumMountainRemovals(new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64});
    }
}
