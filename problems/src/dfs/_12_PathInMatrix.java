package dfs;//[Backtracking],[Depth-First Search]

public class _12_PathInMatrix {

    public static boolean hasPath(char[][] matrix, String path) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix,visited,path,0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] matrix,
                               boolean[][] visited,
                               String path, int pos, int i, int j) {
        int m = matrix.length;
        int n= matrix[0].length;
        // Guard condition
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false; // outside the boundary
        }
        if (visited[i][j]) {
            return false; // already visited
        }
        if (pos >= path.length()) {
            return true;
        }

        // set state
        visited[i][j] = true;
        if (path.charAt(pos) == matrix[i][j]) {
            boolean up = dfs(matrix, visited, path, pos + 1, i - 1, j); // up
            boolean down = dfs(matrix, visited, path, pos + 1, i + 1, j); // down
            boolean left = dfs(matrix, visited, path, pos + 1, i, j - 1); // left
            boolean right = dfs(matrix, visited, path, pos + 1, i, j + 1); // right
            if (up || down || left || right) {
                return true;
            }
        }
        // revert state
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };

        boolean p1 = hasPath(matrix, "bfce"); // true
        boolean p5 = hasPath(matrix, "bfcf"); // false
        boolean p2 = hasPath(matrix, "abfb"); // false
        boolean p3 = hasPath(matrix, "tbfc"); // true
        boolean p4 = hasPath(matrix, "acfs"); // false
    }
}
