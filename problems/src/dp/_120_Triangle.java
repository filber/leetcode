package dp;

//https://leetcode.com/problems/triangle/

import java.util.List;

public class _120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // dp[i][j]: minimum path sum when starting from top to reach triangle[i][j]
        dp[0][0] = triangle.get(0).get(0); // top
        for (int i = 1; i < n; i++) {
            List<Integer> arr = triangle.get(i);
            dp[i][0] = arr.get(0) + dp[i - 1][0]; // most left
            for (int j = 1; j < i; j++) {
                // middle
                dp[i][j] = arr.get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
            dp[i][i] = arr.get(i) + dp[i - 1][i - 1]; // most right
        }

        // result = min(dp[n-1][j])
        int result = Integer.MAX_VALUE;
        for (int val : dp[n - 1]) {
            result = Math.min(result, val);
        }
        return result;
    }
}
