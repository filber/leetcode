package dfs;

//https://leetcode.com/problems/shortest-bridge/

public class _934_ShortestBridge {

    int[][] groups;
    int[][][] distance;
    int[][] grid;
    int n;
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void separate(int i, int j, int groupId) {
        if (i < 0 || i == n || j < 0 || j == n) {
            return;
        } else if (grid[i][j] == 0) {
            return;
        } else if (groups[i][j] != 0) {
            return;
        }
        groups[i][j] = groupId;
        separate(i - 1, j, groupId);
        separate(i + 1, j, groupId);
        separate(i, j - 1, groupId);
        separate(i, j + 1, groupId);
    }

    private int dist(int i, int j, int groupId) {
        if (i < 0 || i == n || j < 0 || j == n) {
            return Integer.MAX_VALUE;
        } else if (grid[i][j] == 1) {
            if (groups[i][j] == groupId) {
                return 0;
            }
            return Integer.MAX_VALUE;
        } else if (distance[i][j][groupId] != 0) {
            return distance[i][j][groupId];
        }

        int D = Integer.MAX_VALUE;
        distance[i][j][groupId] = D;
        for (int k = 0; k < DIR.length; k++) {
            int nextI = i + DIR[k][0];
            int nextJ = j + DIR[k][1];
            int dist = dist(nextI, nextJ, groupId);
            D = Math.min(D, dist);
        }
        if (D == Integer.MAX_VALUE) {
            distance[i][j][groupId] = D;
        } else {
            distance[i][j][groupId] = D + 1;
        }
        return distance[i][j][groupId];
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        groups = new int[n][n];
        distance = new int[n][n][3];

        int groupId = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (groups[i][j] == 0 && grid[i][j] == 1) {
                    separate(i, j, groupId);
                    groupId++;
                }
            }
        }

        int minD = Integer.MAX_VALUE;
        // closest distance to BOTH groups
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int dA = dist(i, j, 1);
                    int dB = dist(i, j, 2);
                    if (dA != Integer.MAX_VALUE && dB != Integer.MAX_VALUE) {
                        minD = Math.min(minD, dA + dB);
                    }
                }
            }
        }
        return minD - 1;
    }
}
