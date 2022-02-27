package dfs;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {

    List<List<String>> ans = new ArrayList<>();
    boolean[] col;
    boolean[] slash;
    boolean[] backslash;
    int n;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new boolean[n];
        slash = new boolean[2 * n - 1];
        backslash = new boolean[2 * n - 1];

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(0);

        return ans;
    }

    private void dfs(int i) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                list.add(new String(board[k]));
            }
            ans.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (col[j] || slash[i + j] || backslash[j - i + n - 1]) {
                continue;
            }
            board[i][j] = 'Q';
            col[j] = slash[i + j] = backslash[j - i + n - 1] = true;

            dfs(i + 1);

            board[i][j] = '.';
            col[j] = slash[i + j] = backslash[j - i + n - 1] = false;
        }
    }

}
