package list;

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
        int[] subsequences = longestCommonSubsequences(arr, 0, arr.length - 1);

        List<Integer> ans = new ArrayList<>(subsequences.length);
        for (int val : subsequences) {
            ans.add(val);
        }
        return ans;
    }

    // Divide and Conquer
    public int[] longestCommonSubsequences(int[][] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }

        int mid = (i + j) / 2;
        int[] left = longestCommonSubsequences(arr, i, mid);
        int[] right = longestCommonSubsequences(arr, mid + 1, j);
        int[] ans = new int[Math.max(left.length, right.length)];
        int len = 0;

        // Two Pointers
        int l = 0, r = 0;
        while (l < left.length && r < right.length) {
            int leftVal = left[l];
            int rightVal = right[r];
            if (leftVal == rightVal) {
                ans[len++] = leftVal;
                l++;
                r++;
            } else if (leftVal < rightVal) {
                l++;
            } else {
                r++;
            }
        }

        return Arrays.copyOf(ans, len);
    }
}
