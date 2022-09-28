package graph;

import java.util.HashSet;
import java.util.Set;

public class _305_NumberOfIslandsII {

    // A 2d grid map of m rows and n columns is initially filled with water.
    // We may perform an addLand operation which turns the water at position (row, col) into a land.
    // Given a list of positions to operate, count the number of islands after each addLand operation.
    // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    // You may assume all four edges of the grid are all surrounded by water.

    int[] ids;
    int[] sz;

    public int[] numIslands2(int m, int n, int[][] positions) {
        int k = positions.length;
        ids = new int[k + 1];
        sz = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            ids[i] = i;
            sz[i] = 1;
        }

        int[][] grid = new int[m][n];
        int[][] DIR = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int[] islands = new int[k];
        islands[0] = 1;
        grid[positions[0][0]][positions[0][1]] = 1;
        for (int l = 1; l < k; l++) {
            int[] pos = positions[l];
            int i = pos[0];
            int j = pos[1];
            grid[i][j] = l + 1;
            islands[l] = islands[l - 1];
            Set<Integer> set = new HashSet<>();
            for (int[] d : DIR) {
                int nextI = i + d[0];
                int nextJ = j + d[1];
                if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n || grid[nextI][nextJ] == 0) {
                    continue;
                }
                int id = find(grid[nextI][nextJ]);
                union(l + 1, id);
                set.add(id);
            }
            islands[l] -= (set.size() - 1);
        }

        return islands;
    }

    private void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        int pSz = sz[pId];
        int qSz = sz[qId];
        if (pSz > qSz) {
            ids[qId] = pId;
            sz[pId] += qSz;
        } else {
            ids[pId] = qId;
            sz[qId] += pSz;
        }
    }

    private int find(int i) {
        while (ids[i] != i) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
}
