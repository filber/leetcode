package dfs;

// https://leetcode.com/problems/max-area-of-island/

//TOPICS:
//[Union Find],[Depth-First Search]
public class _695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Update maxArea
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // 0. Guard condition
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        } else if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // mark as searched
        // 1. DFS for four directions
        int area = 1 +
                dfs(grid, i - 1, j) +
                dfs(grid, i + 1, j) +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1);

        return area;
    }


    private int[] id;
    private int[] sz;
    private int m;
    private int n;
    private int[][] grid;
    private int maxSz = 0;

    public int maxAreaOfIslandUnionFind(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        // Init Union-Find variables
        id = new int[m * n];
        sz = new int[m * n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            if (grid[i / n][i % n] == 1) {
                sz[i] = 1;
                maxSz = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionGrid(i,j,i-1,j); // up
                    unionGrid(i,j,i+1,j); // down
                    unionGrid(i,j,i,j-1); // left
                    unionGrid(i,j,i,j+1); // right
                }
            }
        }

        return maxSz;
    }

    public void unionGrid(int x1, int y1, int x2, int y2) {
        if (x2 < 0 || x2 >= m || y2 < 0 || y2 >= n) {
            return;
        } else if (grid[x2][y2]==0) {
            return;
        }

        int p = x1 * n + y1;
        p = root(p);
        int q = x2 * n + y2;
        q = root(q);
        if (p != q) {
            union(p, q);
        }
    }

    public void union( int p, int q) {
        int pid = root(p);
        int qid = root(q);

        //Weighted-Quick-Union
        if (sz[p]<sz[q]) {
            // p is smaller
            id[pid] = qid; // attach p to q
            sz[q] += sz[p];
        } else {
            // q is smaller
            id[qid] = pid; // attach q to p
            sz[p] += sz[q];
        }
        maxSz = Math.max(Math.max(maxSz, sz[p]), sz[q]);
    }

    public int root(int i) {
        while (i != id[i]) {
            // path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public static void main(String[] args) {
        int m4 = new _695_MaxAreaOfIsland().maxAreaOfIsland(
                new int[][]{{1}});
        int m1 = new _695_MaxAreaOfIsland().maxAreaOfIsland(
                new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}});
        int m2 = new _695_MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {1, 0, 1, 1},
                { 1, 0, 1, 0}});

        int m3 = new _695_MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}});
    }
}
