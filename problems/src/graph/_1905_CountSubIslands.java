package graph;

//https://leetcode.com/problems/count-sub-islands/

public class _1905_CountSubIslands {

    int[][] DIR = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    int m;
    int n;
    boolean[][] visited;
    int[][] M1;
    int[][] M2;

    boolean allContained;

    public int countSubIslands(int[][] M1, int[][] M2) {
        m = M1.length;
        n = M1[0].length;
        visited = new boolean[m][n];
        this.M1 = M1;
        this.M2 = M2;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(M2[i][j] == 1 && !visited[i][j]) {
                    allContained = true;
                    dfs(i, j);
                    if (allContained) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        if (M1[i][j] == 0) {
            allContained = false;
        }
        visited[i][j] = true;
        for (int[] dir : DIR) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n) {
                continue;
            } else if (M2[nextI][nextJ] == 0 || visited[nextI][nextJ]) {
                continue;
            }
            dfs(nextI, nextJ);
        }
    }
}
