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

        int[][] dp = new int[m][n];
        int[] cost = new int[m];
        for (int i = 0; i < m; i++) {
            cost[i] = Math.abs(locations[i] - locations[finish]);
        }

        Arrays.fill(dp[finish], 1);

        for (int j = 1; j <= fuel; j++) {
            for (int i = 0; i < m; i++) {
                int cost1 = cost[i];
                if (cost1 <= j) {
                    // Iterate all reachable cities with fuel = j

                    // search left
                    int l = i - 1;
                    while (l >= 0 && (locations[i] - locations[l]) <= j) {
                        int cost2 = locations[i] - locations[l];
                        dp[i][j] = (dp[i][j] + dp[l][j - cost2]) % modulo;
                        l--;
                    }

                    // search right
                    int r = i + 1;
                    while (r < m && (locations[r] - locations[i]) <= j) {
                        int cost2 = locations[r] - locations[i];
                        dp[i][j] = (dp[i][j] + dp[r][j - cost2]) % modulo;
                        r++;
                    }
                }
            }
        }

        return dp[start][fuel];
    }
}
