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

        // 1. Build Graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        // 2. Figure out the best path for each city
        int len = targetPath.length;
        int[][] dp = new int[len][n]; // store edit distance between Target & Cities
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        List<Integer>[] path1 = new List[n]; // best path ending with city i
        List<Integer>[] path2 = new List[n]; // status of next path
        for (int j = 0; j < n; j++) {
            if (!names[j].equals(targetPath[0])) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
            path1[j] = new ArrayList<>();
            path1[j].add(j);
        }


        for (int k = 1; k < len; k++) {
            for (int i = 0; i < n; i++) {
                if (dp[k - 1][i] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j : graph[i]) {
                    // j: next linked city
                    int editDistance = names[j].equals(targetPath[k]) ? 0 : 1;

                    if (dp[k][j] > dp[k - 1][i] + editDistance) {
                        dp[k][j] = dp[k - 1][i] + editDistance;
                        path2[j] = new ArrayList<>(path1[i]);
                        path2[j].add(j);
                    }
                }
            }
            // swap path1 and path2, rolling array, refresh the best path to path1
            List<Integer>[] tmp = path2;
            path2 = path1;
            path1 = tmp;
        }

        int minDistance = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < n; i++) {
            if (minDistance > dp[len - 1][i]) {
                minDistance = dp[len - 1][i];
                minIdx = i;
            }
        }

        return path1[minIdx];
    }
}
