package dp;

//https://leetcode.com/problems/champagne-tower/

public class _799_ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = (double) poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double spill = (dp[i][j] - 1) / 2;
                    dp[i + 1][j] += spill;
                    dp[i + 1][j + 1] += spill;
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}
