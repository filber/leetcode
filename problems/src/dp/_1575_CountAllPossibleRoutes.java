package dp;

//https://leetcode.com/problems/count-all-possible-routes/

import java.util.Arrays;

public class _1575_CountAllPossibleRoutes {

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int modulo = (int) (1e9 + 7);
        int startCity = locations[start];
        int endCity = locations[finish];
        Arrays.sort(locations);
        start = Arrays.binarySearch(locations, startCity);
        finish = Arrays.binarySearch(locations, endCity);

        int m = locations.length;
        int n = fuel + 1;

        // dp[j][i][0]: STAY at city i with j fuel remain
        // dp[j][i][1]: moving RIGHT through city i with j fuel remain
        // dp[j][i][2]: moving LEFT through city i with j fuel remain
        int[][][] dp = new int[n][m][3];
        dp[fuel][start][0] = 1;

        for (int j = fuel; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (i > 0 && locations[i] - locations[i - 1] + j <= fuel) {
                    int gas = locations[i] - locations[i - 1]; // spent gas from i-1 to i
                    dp[j][i][0] = (dp[j][i][0] + dp[j + gas][i - 1][0] + dp[j + gas][i - 1][1]) % modulo;
                    dp[j][i][1] = (dp[j][i][1] + dp[j + gas][i - 1][0] + dp[j + gas][i - 1][1]) % modulo;
                }

                if (i < m - 1 && locations[i + 1] - locations[i] + j <= fuel) {
                    int gas = locations[i + 1] - locations[i]; // spent gas from i+1 to i
                    dp[j][i][0] = (dp[j][i][0] + dp[j + gas][i + 1][0] + dp[j + gas][i + 1][2]) % modulo;
                    dp[j][i][2] = (dp[j][i][2] + dp[j + gas][i + 1][0] + dp[j + gas][i + 1][2]) % modulo;
                }
            }
        }

        long sum = 0;
        for (int j = 0; j <= fuel; j++) {
            sum += dp[j][finish][0];
        }
        return (int) (sum % modulo);
    }
}
