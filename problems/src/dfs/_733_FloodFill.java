package dfs;

public class _733_FloodFill {

    boolean[][] visited;
    int m;
    int n;
    int[][] image;
    int color;
    int baseColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.color = color;
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        baseColor = image[sr][sc];
        dfs(sr, sc);
        return image;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return;
        } else if (visited[i][j]) {
            return;
        } else if (image[i][j] != baseColor) {
            return;
        }
        image[i][j] = color;
        visited[i][j] = true;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
