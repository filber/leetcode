package bfs;

//https://leetcode.com/problems/trapping-rain-water-ii/

import java.util.PriorityQueue;

public class _407_TrappingRainWaterII {

    public class Pair {
        int row;
        int col;
        int val;

        Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int trapRainWater(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pq.add(new Pair(i, 0, heights[i][0]));
            pq.add(new Pair(i, n - 1, heights[i][n - 1]));
            vis[i][0] = true;
            vis[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.add(new Pair(0, j, heights[0][j]));
            pq.add(new Pair(m - 1, j, heights[m - 1][j]));
            vis[0][j] = true;
            vis[m - 1][j] = true;
        }

        int ans = 0;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            for (int i = 0; i < 4; i++) {
                int r = p.row + dir[i][0];
                int c = p.col + dir[i][1];

                if (r >= 0 && c >= 0 && r < m && c < n && !vis[r][c]) {
                    vis[r][c] = true;
                    if (p.val > heights[r][c]) {
                        ans += p.val - heights[r][c];
                        pq.add(new Pair(r, c, p.val));
                    } else {
                        pq.add(new Pair(r, c, heights[r][c]));
                    }
                }
            }
        }

        return ans;
    }
}
