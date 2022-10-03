package dfs;

//https://leetcode.com/problems/sudoku-solver/

import java.util.ArrayList;
import java.util.List;

public class _37_SudokuSolver {

    // A sudoku solution must satisfy all of the following rules:
    //    Each of the digits 1-n must occur exactly once in each row.
    //    Each of the digits 1-n must occur exactly once in each column.
    //    Each of the digits 1-n must occur exactly once in each of the n 3x3 sub-boxes of the grid.

    public void solveSudoku(char[][] board) {
        // whether digit j has been used for row i, if yes, r_r[i][j-1] = true
        boolean[][] row_record = new boolean[9][9];
        // whether digit j has been used for col i, if yes, c_r[i][j-1] = true
        boolean[][] col_record = new boolean[9][9];
        // whether digit j has been used for grid[p][q], if yes, g_r[p][q] = true
        boolean[][][] grid_record = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    row_record[i][digit - 1] = true;
                    col_record[j][digit - 1] = true;
                    grid_record[i / 3][j / 3][digit - 1] = true;
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(new int[]{i, j});
                }
            }
        }
        backtracking(board, row_record, col_record, grid_record, list, 0);
    }

    private boolean backtracking(char[][] board, boolean[][] row_record, boolean[][] col_record, boolean[][][] grid_record, List<int[]> list, int i) {
        if (i == list.size()) {
            return true;
        }
        int[] pair = list.get(i);
        int x = pair[0];
        int y = pair[1];
        for (char cand = '1'; cand <= '9'; cand++) {
            if (row_record[x][cand - '1'] || col_record[y][cand - '1'] || grid_record[x / 3][y / 3][cand - '1']) {
                continue;
            }
            // set states
            row_record[x][cand - '1'] = true;
            col_record[y][cand - '1'] = true;
            grid_record[x / 3][y / 3][cand - '1'] = true;
            board[x][y] = cand;
            if (backtracking(board, row_record, col_record, grid_record, list, i + 1)) {
                return true;
            }

            // reverse states
            row_record[x][cand - '1'] = false;
            col_record[y][cand - '1'] = false;
            grid_record[x / 3][y / 3][cand - '1'] = false;
            board[x][y] = '.';
        }

        return false;
    }
}
