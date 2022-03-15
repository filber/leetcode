package graph;

//https://blog.csdn.net/qq_21201267/article/details/107983113

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1548_TheMostSimilarPathInAGraph {

    public int editDistance(String[] targetPath, String[] names, Integer[] path) {
        int m = targetPath.length;
        int n = path.length;
        if (m != n) {
            return Integer.MAX_VALUE;
        }

        int dis = 0;
        for (int i = 0; i < m; i++) {
            if (!targetPath[i].equals(names[path[i]])) {
                dis++;
            }
        }
        return dis;
    }

    public List<Integer> mostSimilar(String[] names, int[][] roads, String[] targetPath) {
        int n = names.length;
        int m = targetPath.length;
        // 1. Build Graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            graph[r[0]].add(r[1]);
            graph[r[1]].add(r[0]);
        }

        // 2. Figure out the best path for each city

        // DP[i][j]: minimum edit distance for
        // targetPath.substring[0,i] if ending with city j
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[][] path1 = new int[n][1]; // best path for city
        int[][] path2 = new int[n][1]; // best candidate paths
        for (int j = 0; j < n; j++) {
            int editDistance = targetPath[0].equals(names[j]) ? 0 : 1;
            dp[0][j] = editDistance;
            path1[j][0] = j; // path starts with j
        }

        for (int k = 1; k < m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j : graph[i]) {
                    // Using dp[k-1][i] to refresh all the linked cities of i, dp[k][j]
                    int editDistance = targetPath[k].equals(names[j]) ? 0 : 1;
                    if (dp[k][j] > dp[k - 1][i] + editDistance) {
                        dp[k][j] = dp[k - 1][i] + editDistance;
                        path2[j] = Arrays.copyOf(path1[i], k + 1);
                        path2[j][k] = j; // append city j
                    }
                }
            }
            // swap path1 and path2
            int[][] tmp = path2;
            path2 = path1;
            path1 = tmp;
        }

        // 3. Find the best path with the minimum edit distance
        int minDistance = Integer.MAX_VALUE, minIdx = 0;
        for (int j = 0; j < n; j++) {
            if (dp[m - 1][j] < minDistance) {
                minDistance = dp[m - 1][j];
                minIdx = j;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int city : path1[minIdx]) {
            ans.add(city);
        }
        return ans;
    }
}
