package dp;

//https://leetcode.com/problems/ones-and-zeroes/

public class _474_OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int ones = 0;
            int zeros = 0;
            for (char ch : str.toCharArray()) {
                zeros += '1' - ch;
                ones += ch - '0';
            }

            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j - zeros][k - ones] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm3D(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] count = new int[len][2];
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            for (char ch : chars) {
                count[i][0] += '1' - ch;
                count[i][1] += ch - '0';
            }
        }

        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            int zeroCnt = count[i - 1][0];
            int oneCnt = count[i - 1][1];
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= zeroCnt && k >= oneCnt) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - zeroCnt][k - oneCnt] + 1, dp[i - 1][j][k]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[len][m][n];
    }
}
