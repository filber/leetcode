package graph;

//https://leetcode.com/problems/is-graph-bipartite/

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
}