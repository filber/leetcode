package dfs;

//https://leetcode.com/problems/word-search/

public class _79_WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, visited, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, boolean[][] visited, char[] chars, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        if (k == chars.length) {
            return true;
        } else if (i < 0 || i == m || j < 0 || j == n) {
            return false;
        } else if (visited[i][j]) {
            return false;
        } else if (board[i][j] != chars[k]) {
            return false;
        }
        visited[i][j] = true;
        if (backtracking(board, visited, chars, i - 1, j, k + 1) ||
                backtracking(board, visited, chars, i + 1, j, k + 1) ||
                backtracking(board, visited, chars, i, j - 1, k + 1) ||
                backtracking(board, visited, chars, i, j + 1, k + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
