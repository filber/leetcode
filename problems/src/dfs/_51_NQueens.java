package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51_NQueens {

    boolean[] row;
    boolean[] col;
    boolean[] slash;
    boolean[] backslash;
    char[][] board;
    int n;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        row = new boolean[n];
        col = new boolean[n];
        slash = new boolean[2 * n - 1];
        backslash = new boolean[2 * n - 1];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == n) {
            // add to ans
            List<String> list = new ArrayList<>(n);
            for (int r = 0; r < n; r++) {
                list.add(new String(board[r]));
            }
            ans.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            int slashIdx = i + j;
            int backslashIdx = i - j + n - 1;
            if (row[i] || col[j] || slash[slashIdx] || backslash[backslashIdx]) {
                continue;
            }

            // set states
            board[i][j] = 'Q';
            row[i] = true;
            col[j] = true;
            slash[slashIdx] = true;
            backslash[backslashIdx] = true;

            dfs(i + 1);

            // reverse states
            board[i][j] = '.';
            row[i] = false;
            col[j] = false;
            slash[slashIdx] = false;
            backslash[backslashIdx] = false;
        }
    }
}
