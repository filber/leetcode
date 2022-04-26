package tree;

//https://leetcode.com/problems/min-cost-to-connect-all-points/

import java.util.Arrays;

public class _1584_MinCostToConnectAllPoints {

    // Kruskal
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n * (n - 1) / 2][];

        id = new int[n];
        sz = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            // union find init
            sz[i] = 1;
            id[i] = i;

            for (int j = i + 1; j < n; j++) {
                int[] edge = new int[3];
                edge[0] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edge[1] = i;
                edge[2] = j;
                edges[idx++] = edge;
            }
        }

        Arrays.sort(edges, (a, b) -> a[0] - b[0]);

        int count = 0;
        int minCost = 0;
        for (int[] edge : edges) {
            int a = edge[1];
            int b = edge[2];
            if (root(a) != root(b)) {
                union(a, b);
                count++;
                minCost += edge[0];
            }
            if (count == n - 1) {
                break;
            }
        }

        return minCost;
    }

    private int[] id;
    private int[] sz;

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);

        //Weighted-Quick-Union
        if (sz[p] < sz[q]) {
            // p is smaller
            id[pid] = qid; // attach p to q
            sz[q] += sz[p];
        } else {
            // q is smaller
            id[qid] = pid; // attach q to p
            sz[p] += sz[q];
        }
    }

    public int root(int i) {
        while (i != id[i]) {
            // path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
