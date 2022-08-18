package dp;

//https://leetcode.com/problems/triangle/

import java.util.List;

public class _120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];
        dp[0] = new int[1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            dp[i] = new int[i + 1];
            dp[i][0] = dp[i - 1][0] + list.get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + list.get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + list.get(i);
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum = Math.min(sum, dp[n - 1][i]);
        }
        return sum;
    }
}
