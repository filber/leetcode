package graph;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

import java.util.*;

public class _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    List<Integer>[] graph;
    int ans = 0;

    public int minReorder(int n, int[][] connections) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] con : connections) {
            int from = con[0], to = con[1];
            graph[from].add(-to);
            graph[to].add(from);
        }
        dfs(0, 0);
        return ans;
    }

    private void dfs(int parent, int i) {
        for (int adj : graph[i]) {
            if (Math.abs(adj) == parent) {
                continue;
            }
            if (adj < 0) {
                ans++;
                adj = -adj;
            }
            dfs(i, adj);
        }
    }

}
