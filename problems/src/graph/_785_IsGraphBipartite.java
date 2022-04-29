package graph;

//https://leetcode.com/problems/is-graph-bipartite/

import java.util.ArrayDeque;
import java.util.Queue;

public class _785_IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] groups = new int[n];
        groups[0] = 1;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (!dfs(graph, visited, groups, 0, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, boolean[] visited, int[] groups, int pGroup, int i) {
        if (visited[i]) {
            return groups[i] != pGroup;
        }
        visited[i] = true;
        groups[i] = 1 - pGroup;
        for (int adj : graph[i]) {
            if (!dfs(graph, visited, groups, groups[i], adj)) {
                return false;
            }
        }
        return true;
    }


    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] groups = new int[n];
        groups[0] = 1;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            queue.add(i);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                int g = groups[node];
                for (int adj : graph[node]) {
                    if (visited[adj] && groups[adj] != g) {
                        continue;
                    } else if (visited[adj]) {
                        return false;
                    } else {
                        groups[adj] = 1 - g;
                        visited[adj] = true;
                        queue.add(adj);
                    }
                }
            }
        }

        return true;
    }
}
