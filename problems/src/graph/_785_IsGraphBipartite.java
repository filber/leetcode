package graph;

//https://leetcode.com/problems/is-graph-bipartite/

import java.util.ArrayDeque;
import java.util.Queue;

public class _785_IsGraphBipartite {
    int n;
    int[] groups;
    int[][] graph;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        groups = new int[n];
        this.graph = graph;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]){
                continue;
            }

            groups[i] = 1;
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i) {
        if (visited[i]) {
            return true;
        }
        visited[i] = true;

        int[] neighbors = graph[i];
        int g = groups[i];
        for (int nei : neighbors) {
            if (groups[nei] != 0 && groups[nei] == g) {
                return false;
            } else {
                groups[nei] = 3 - g;
                if (!dfs(nei)) {
                    return false;
                }
            }
        }

        return true;
    }
}