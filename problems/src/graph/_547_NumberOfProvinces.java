package graph;

//[Graph],[Depth-First Search]

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-provinces/
public class _547_NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                cnt++;
            }
        }
        return cnt;
    }

    // traverse all nodes connected with i
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        int n = isConnected.length;
        int[] edge = isConnected[i];
        for (int j = 0; j < n; j++) {
            if (j != i && edge[j] == 1) {
                dfs(isConnected, visited, j);
            }
        }
    }


    private int[] idx;
    private int[] sz;

    public int findCircleNumUnionFind(int[][] isConnected) {
        int n = isConnected.length;

        idx = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] != 0 && i != j) {
                    // Union edge
                    union(i, j);
                }
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(find(i));
        }

        return roots.size();
    }

    private void union(int l, int r) {
        int lRoot = find(l);
        int rRoot = find(r);
        if (lRoot == rRoot) {
            return;
        }
        // Weighted Union
        if (sz[lRoot] < sz[rRoot]) {
            // link lRoot to rRoot
            idx[lRoot] = rRoot;
            sz[rRoot] += sz[lRoot];
        } else {
            // link  to lRoot
            idx[rRoot] = lRoot;
            sz[lRoot] += sz[rRoot];
        }
    }

    private int find(int id) {
        int root = id;

        while (root != idx[root]) {
            int pre = root;
            root = idx[root];
            // Compress Quick Find
            idx[pre] = idx[idx[pre]];
        }
        return root;
    }
}
