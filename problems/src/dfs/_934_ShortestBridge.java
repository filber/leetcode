package dfs;

//https://leetcode.com/problems/shortest-bridge/

import java.util.ArrayDeque;
import java.util.Queue;

public class _934_ShortestBridge {

    int[][] groups;
    int[][][] distance;
    int[][] grid;
    int n;


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

    public int shortestBridgeDFS(int[][] grid) {
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


    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] groups = new int[n][n];
        int groupId = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && groups[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    groups[i][j] = groupId;
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        int x = node[0];
                        int y = node[1];
                        for (int k = 0; k < DIR.length; k++) {
                            int nextX = x + DIR[k][0];
                            int nextY = y + DIR[k][1];
                            if (nextX < 0 || nextX == n || nextY < 0 || nextY == n ||
                                    grid[nextX][nextY] == 0 || groups[nextX][nextY] > 0) {
                                continue;
                            }
                            groups[nextX][nextY] = groupId;
                            queue.add(new int[]{nextX, nextY});
                        }
                    }
                    groupId++;
                }
            }
        }


        Queue<int[]> A = new ArrayDeque<>();
        Queue<int[]> B = new ArrayDeque<>();

        int[][][] distance = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (groups[i][j] == 1) {
                    A.add(new int[]{i, j});
                } else if (groups[i][j] == 2) {
                    B.add(new int[]{i, j});
                } else {
                    distance[i][j][0] = Integer.MAX_VALUE;
                    distance[i][j][1] = Integer.MAX_VALUE;
                }
            }
        }

        BFS(A, grid, distance, 0);
        BFS(B, grid, distance, 1);
        int rst = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j][0] == Integer.MAX_VALUE || distance[i][j][1] == Integer.MAX_VALUE) {
                    continue;
                }
                int length = distance[i][j][0] + distance[i][j][1];
                if (grid[i][j] == 0 && rst > length) {
                    rst = length;
                }
            }
        }
        return rst - 1;
    }

    private void BFS(Queue<int[]> queue, int[][] grid, int[][][] distance, int gId) {
        int n = grid.length;
        int dist = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                for (int k = 0; k < DIR.length; k++) {
                    int nextX = x + DIR[k][0];
                    int nextY = y + DIR[k][1];
                    if (nextX < 0 || nextX == n || nextY < 0 || nextY == n ||
                            grid[nextX][nextY] == 1 || distance[nextX][nextY][gId] != Integer.MAX_VALUE) {
                        continue;
                    }
                    distance[nextX][nextY][gId] = dist;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            dist++;
        }
    }

}
