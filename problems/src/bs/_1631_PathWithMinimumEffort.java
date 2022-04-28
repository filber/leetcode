package bs;

//https://leetcode.com/problems/path-with-minimum-effort/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _1631_PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] edges = new int[m * (n - 1) + n * (m - 1)][3];
        int edgeIdx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int gridIdx = i * n + j;
                int h = heights[i][j];
                if (j < n - 1) {
                    int effort = Math.abs(heights[i][j + 1] - h);
                    int rightIdx = i * n + j + 1;
                    edges[edgeIdx][0] = effort;
                    edges[edgeIdx][1] = gridIdx;
                    edges[edgeIdx][2] = rightIdx;
                    edgeIdx++;
                }

                if (i < m - 1) {
                    int effort = Math.abs(heights[i + 1][j] - h);
                    int downIdx = (i + 1) * n + j;
                    edges[edgeIdx][0] = effort;
                    edges[edgeIdx][1] = gridIdx;
                    edges[edgeIdx][2] = downIdx;
                    edgeIdx++;
                }
            }
        }

        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        int[] id = new int[m * n];
        int[] sz = new int[m * n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        int firstIdx = 0, lastIdx = m * n - 1;
        for (int[] edge : edges) {
            int len = edge[0];
            int from = edge[1];
            int to = edge[2];
            union(id, sz, from, to);

            if (root(id, firstIdx) == root(id, lastIdx)) {
                return len;
            }
        }

        return 0;
    }

    private void union(int[] id, int[] sz, int p, int q) {
        int pId = root(id, p);
        int qId = root(id, q);
        if (pId == qId) {
            return;
        }
        if (sz[pId] > sz[qId]) {
            id[qId] = pId;
            sz[pId] += sz[qId];
        } else {
            id[pId] = qId;
            sz[qId] += sz[pId];
        }
    }

    private int root(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }


    public int minimumEffortPathBS(int[][] heights) {
        int l = 0, r = (int) 1e6;
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean valid = bfs(heights, m);
            if (valid) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean bfs(int[][] heights, int effort) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];
            int h = heights[i][j];
            if (i == m - 1 && j == n - 1) {
                return true;
            }

            for (int[] dir : DIR) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n) {
                    continue;
                }
                if (visited[nextI][nextJ] || Math.abs(h - heights[nextI][nextJ]) > effort) {
                    continue;
                }
                visited[nextI][nextJ] = true;
                queue.add(new int[]{nextI, nextJ});
            }
        }

        return false;
    }

}
