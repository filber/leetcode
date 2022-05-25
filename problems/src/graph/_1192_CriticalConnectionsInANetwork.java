package graph;

//https://leetcode.com/problems/critical-connections-in-a-network/

import java.util.ArrayList;
import java.util.List;

public class _1192_CriticalConnectionsInANetwork {

    int[] low;
    int[] dfn;
    int seq = 0;
    boolean[] visited;
    List<Integer>[] graph;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        low = new int[n];
        dfn = new int[n];
        visited = new boolean[n];
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 1. Build the graph
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }

        // 2. DFS Traverse
        dfs(-1, 0);

        return ans;
    }

    private void dfs(int parent, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        low[i] = seq++;
        dfn[i] = low[i];
        for (int adj : graph[i]) {
            // do not walk back!
            if (adj == parent) continue;
            dfs(i, adj);
            // update low idx
            low[i] = Math.min(low[i], low[adj]);
            // compare current idx with the low idx of adj
            if (dfn[i] < low[adj]) {
                ans.add(List.of(i, adj));
            }
        }
    }
}
