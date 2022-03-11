package list;

// https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1940_LongestCommonSubsequenceBetweenSortedArrays {
    // Constraints:
    // 2<=arr.length<=100
    // 1<=arr[i].length<=100
    // 1<=arr[i][j]<=100
    // arr[i] is in strict increasing order

    public List<Integer> longestCommonSubsequences(int[][] arr) {
        int n = arr.length;
        int[] common = lCS(arr, 0, n - 1);
        List<Integer> ans = new ArrayList<>(common.length);
        for (int num : common) {
            ans.add(num);
        }
        return ans;
    }

    private int[] lCS(int[][] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        int mid = (i + j) / 2;
        int[] left = lCS(arr, i, mid);
        int[] right = lCS(arr, mid + 1, j);
        int l = 0, r = 0;
        int m = left.length;
        int n = right.length;
        int[] ans = new int[Math.min(m, n)];
        int len = 0;

        while (l < m && r < n) {
            if (left[l] == right[r]) {
                ans[len++] = left[l];
                l++;
                r++;
            } else if (left[l] < right[r]) {
                l++;
            } else {
                r++;
            }
        }

        return Arrays.copyOf(ans, len);
    }
}
