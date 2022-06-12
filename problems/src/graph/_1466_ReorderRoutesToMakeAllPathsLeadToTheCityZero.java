package graph;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

import java.util.*;

public class _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    List<Integer>[] graph;
    int ans = 0;

    public int minReorder(int n, int[][] connections) {
        // 1. Construct Graph
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph[from].add(to);
            graph[to].add(-from);
        }
        dfs(0, 0);

        return ans;
    }

    private void dfs(int parent, int i) {
        for (int adj : graph[i]) {
            int absAdj = Math.abs(adj);
            if (absAdj == parent) {
                continue;
            }
            if (adj > 0) {
                ans++;
            }
            dfs(i, absAdj);
        }
    }


}
