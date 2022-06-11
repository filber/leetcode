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
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(-1, 0);
        return ans;
    }

    private void dfs(int parent, int i) {
        if (visited[i]) {
            return;
        }
        dfn[i] = seq;
        low[i] = seq++;
        visited[i] = true;
        for (int j : graph[i]) {
            if (j == parent) {
                continue;
            }
            dfs(i, j);
            low[i] = Math.min(low[i], low[j]);
            if (dfn[i] < low[j]) {
                ans.add(List.of(i, j));
            }
        }
    }
}
