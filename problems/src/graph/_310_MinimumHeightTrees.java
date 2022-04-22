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

        int[] order = new int[2];
        int sz = n - 1;
        while (!queue.isEmpty()) {
            sz = queue.size();
            order[0] = queue.peek();
            for (int j = 0; j < sz; j++) {
                int from = queue.poll();
                order[1] = from;

                for (int to : graph[from]) {
                    degree[to]--;
                    if (!visited[to] && degree[to] == 1) {
                        queue.add(to);
                        visited[to] = true;
                    }
                }
            }
        }

        // at most two central nodes
        List<Integer> list = new ArrayList<>();
        list.add(order[0]);
        if (sz == 2) {
            list.add(order[1]);
        }

        return list;
    }
}
