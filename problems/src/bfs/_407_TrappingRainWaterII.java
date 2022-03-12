package bfs;

//https://leetcode.com/problems/trapping-rain-water-ii/

import java.util.PriorityQueue;

public class _407_TrappingRainWaterII {

    public class Node {
        int row;
        int col;
        int height;

        Node(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        if (m <= 2 || n <= 2) {
            return 0;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            queue.add(new Node(i, 0, heights[i][0]));
            visited[i][0] = true;
            queue.add(new Node(i, n - 1, heights[i][n - 1]));
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            queue.add(new Node(0, j, heights[0][j]));
            visited[0][j] = true;
            queue.add(new Node(m - 1, j, heights[m - 1][j]));
            visited[m - 1][j] = true;
        }

        int volume = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // try four directions
            for (int i = 0; i < 4; i++) {
                int r = directions[i][0] + node.row;
                int c = directions[i][1] + node.col;
                if (r > 0 && r < m - 1 && c > 0 && c < n - 1 && !visited[r][c]) {
                    int h = heights[r][c];
                    if (h < node.height) {
                        volume += node.height - h;
                        queue.add(new Node(r, c, node.height));
                    } else {
                        queue.add(new Node(r, c, h));
                    }
                    visited[r][c] = true;
                }
            }
        }

        return volume;
    }
}
