package tree;

//https://leetcode.com/problems/min-cost-to-connect-all-points/

import java.util.Arrays;
import java.util.PriorityQueue;

public class _1584_MinCostToConnectAllPoints {

    // Prime
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDistances = new int[n];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        boolean[] merged = new boolean[n];
        merged[0] = true;
        int i = 0;
        int edges = 0;
        int cost = 0;
        while (edges < n - 1) {
            int minJ = 0, minCost = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (merged[j]) {
                    continue;
                }

                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minDistances[j] = Math.min(minDistances[j], dist);

                if (minDistances[j] < minCost) {
                    minCost = minDistances[j];
                    minJ = j;
                }
            }
            cost += minCost;
            i = minJ;
            merged[i] = true;
            edges++;
        }
        return cost;
    }

    // Kruskal
    public int minCostConnectPointsKruskal(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n * (n - 1) / 2][3];
        int edgeIdx = 0;
        int[] id = new int[n];
        int[] sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
            for (int j = i + 1; j < n; j++) {
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[edgeIdx][0] = dis;
                edges[edgeIdx][1] = i;
                edges[edgeIdx][2] = j;
                edgeIdx++;
            }
        }

        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        int count = 0;
        int minCost = 0;
        for (int i = 0; count < n - 1; i++) {
            int[] edge = edges[i];
            int cost = edge[0];
            int a = edge[1];
            int b = edge[2];
            int aRoot = root(id, a);
            int bRoot = root(id, b);
            if (aRoot != bRoot) {
                count++;
                minCost += cost;
                union(id, sz, aRoot, bRoot);
            }
        }
        return minCost;
    }

    private void union(int[] id, int[] sz, int p, int q) {
        if (sz[p] > sz[q]) {
            id[q] = p;
            sz[p] += sz[q];
        } else {
            id[p] = q;
            sz[q] += sz[p];
        }
    }

    int root(int[] id, int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
