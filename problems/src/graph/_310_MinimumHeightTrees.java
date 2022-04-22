package graph;

//https://leetcode.com/problems/minimum-height-trees/

import java.util.*;

public class _310_MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        int[] degree = new int[n];
        List<Integer>[] graph = new List[n];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            degree[from]++;
            degree[to]++;
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            graph[from].add(to);
            if (graph[to] == null) {
                graph[to] = new ArrayList<>();
            }
            graph[to].add(from);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
                visited[i] = true;
            }
        }

        int[] order = new int[n];
        int idx = n - 1;
        int sz = n - 1;
        while (!queue.isEmpty()) {
            sz = queue.size();
            for (int j = 0; j < sz; j++) {
                int from = queue.poll();
                order[idx--] = from;

                for (int to : graph[from]) {
                    degree[to]--;
                    if (!visited[to] && degree[to] == 1) {
                        queue.add(to);
                        visited[to] = true;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sz; i++) {
            list.add(order[i]);
        }
        return list;
    }
}
