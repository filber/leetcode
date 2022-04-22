package graph;

//https://www.geeksforgeeks.org/topological-sorting/

import java.util.ArrayDeque;
import java.util.Queue;

public class _EX_TopologicalSort {

    // BFS
    int[] topologicalOrderBFS(int[][] graph) {
        int v = graph.length;

        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int dest = graph[i][j];
                inDegree[dest]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[v];
        int idx = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            ans[idx++] = vertex;
            for (int des : graph[vertex]) {
                inDegree[des]--;
                if (inDegree[des] == 0) {
                    queue.add(des);
                }
            }
        }
        return ans;
    }


    int[] order;
    int idx;
    int[][] graph;
    boolean[] visited;

    // DFS
    int[] topologicalOrder(int[][] graph) {
        int v = graph.length;
        this.graph = graph;
        visited = new boolean[v];
        order = new int[v];
        idx = v - 1;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        return order;
    }

    private void dfs(int i) {
        if (visited[i]) return;

        for (int j : graph[i]) {
            dfs(j);
        }

        visited[i] = true;
        order[idx--] = i;
    }

}
