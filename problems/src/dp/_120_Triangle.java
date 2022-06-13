package dp;

//https://leetcode.com/problems/triangle/

import java.util.List;

public class _120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i + 1];
        }

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int min = Integer.MAX_VALUE;
                if (j > 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j < i) {
                    min = Math.min(min, dp[i - 1][j]);
                }
                dp[i][j] = min + list.get(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
