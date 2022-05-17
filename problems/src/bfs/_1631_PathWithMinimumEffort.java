package bfs;

//https://leetcode.com/problems/path-with-minimum-effort/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1631_PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int weight = node[0];
            int i = node[1];
            int j = node[2];
            int height = heights[i][j];
            if (weight > dp[i][j]) {
                continue;
            }
            if (i == m - 1 && j == n - 1) {
                return dp[i][j];
            }
            for (int k = 0; k < dir.length; k++) {
                int nextI = dir[k][0] + i;
                int nextJ = dir[k][1] + j;
                if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n) {
                    continue;
                }
                int nextWeight = Math.max(weight, Math.abs(height - heights[nextI][nextJ]));
                if (nextWeight < dp[nextI][nextJ]) {
                    dp[nextI][nextJ] = nextWeight;
                    queue.add(new int[]{nextWeight, nextI, nextJ});
                }
            }
        }

        return 0;
    }

    public int minimumEffortPathUnionFind(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //0:weight
        //1:from Idx
        //2:to Idx
        int[][] edges = new int[m * (n - 1) + n * (m - 1)][];
        int edgeIdx = 0;
        int[] id = new int[m * n];
        int[] sz = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int fromIdx = i * n + j;
                int h = heights[i][j];
                id[fromIdx] = fromIdx;
                sz[fromIdx] = 1;

                // right
                if (j < n - 1) {
                    int toIdx = i * n + j + 1;
                    int[] edge = new int[]{Math.abs(h - heights[i][j + 1]), fromIdx, toIdx};
                    edges[edgeIdx++] = edge;
                }

                // down
                if (i < m - 1) {
                    int toIdx = (i + 1) * n + j;
                    int[] edge = new int[]{Math.abs(h - heights[i + 1][j]), fromIdx, toIdx};
                    edges[edgeIdx++] = edge;
                }
            }
        }
        // sort edges
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        int firstIdx = 0, lastIdx = m * n - 1;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int weight = edge[0];
            int from = edge[1];
            int to = edge[2];
            union(id, sz, from, to);
            if (root(id, firstIdx) == root(id, lastIdx)) {
                return weight;
            }
        }

        return 0;
    }

    int root(int[] id, int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    void union(int[] id, int[] sz, int p, int q) {
        int pId = root(id, p);
        int qId = root(id, q);
        if (pId == qId) {
            return;
        }
        int pSz = sz[pId];
        int qSz = sz[qId];
        if (pSz > qSz) {
            id[qId] = pId;
            sz[pId] += qSz;
        } else {
            id[pId] = qId;
            sz[qId] += pSz;
        }
    }


}
