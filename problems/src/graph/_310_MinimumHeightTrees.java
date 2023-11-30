package graph;

//https://leetcode.com/problems/minimum-height-trees/

import java.util.*;

public class _310_MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            degree[a]++;
            degree[b]++;
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] <= 1) {
                queue.add(i);
                visited[i] = true;
            }
        }

        int sz = queue.size();
        int[] ans = new int[2];
        while (!queue.isEmpty()) {
            sz = queue.size();
            ans[0] = queue.peek();
            for (int i = 0; i < sz; i++) {
                int node = queue.poll();
                ans[1] = node;
                for (int adj : graph[node]) {
                    degree[adj]--;
                    if (!visited[adj] && degree[adj] == 1) {
                        visited[adj] = true;
                        queue.add(adj);
                    }
                }
            }
        }

        if (sz == 1) {
            return Arrays.asList(ans[0]);
        } else {
            return Arrays.asList(ans[0], ans[1]);
        }
    }
}
