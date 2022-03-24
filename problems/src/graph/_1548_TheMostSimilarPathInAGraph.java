package graph;

//https://leetcode.com/problems/the-most-similar-path-in-a-graph/
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
        // 1. Build Graph
        int m = targetPath.length;
        int n = names.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        // 2. Init DP&Paths
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[][] path1 = new int[n][1];
        int[][] path2 = new int[n][1];
        for (int j = 0; j < n; j++) {
            int distance = targetPath[0].equals(names[j]) ? 0 : 1;
            dp[0][j] = distance;
            path1[j][0] = j;
        }

        // 3. Fill DP&Paths
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int preDistance = dp[i - 1][j];
                for (int k : graph[j]) {
                    int nextDistance = targetPath[i].equals(names[k]) ? 0 : 1;
                    if (dp[i][k] > preDistance + nextDistance) {
                        dp[i][k] = preDistance + nextDistance;
                        // Rolling Path
                        path2[k] = Arrays.copyOf(path1[j], i + 1);
                        path2[k][i] = k;
                    }
                }
            }
            // swap path1 and path2
            int[][] temp = path1;
            path1 = path2;
            path2 = temp;
        }

        // 4. Find minimum edit distance
        int minDistance = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int j = 0; j < n; j++) {
            if (dp[m - 1][j] < minDistance) {
                minDistance = dp[m - 1][j];
                minIdx = j;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(path1[minIdx][i]);
        }
        return ans;
    }
}
