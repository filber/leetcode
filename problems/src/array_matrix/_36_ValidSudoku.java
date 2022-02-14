package array_matrix;

//https://leetcode.com/problems/valid-sudoku/

public class _36_ValidSudoku {

    private char[][] board;

    public boolean isValidSudoku(char[][] board) {
        final int n = 9;
        this.board = board;
        boolean[][] rowSet = new boolean[n][n];
        boolean[][] colSet = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char center = board[i][j];
                if (center != '.') {
                    if (rowSet[i][center - '1'] || colSet[j][center - '1']) {
                        return false;
                    } else {
                        rowSet[i][center - '1'] = true;
                        colSet[j][center - '1'] = true;
                    }
                }

                if (i % 3 == 1 && j % 3 == 1) {
                    // sub-box center
                    boolean[] set = new boolean[n];
                    if (!add(set, i, j)
                            || !add(set, i - 1, j)    // up
                            || !add(set, i + 1, j)  // down
                            || !add(set, i, j - 1)  // left
                            || !add(set, i, j + 1)  // right
                            || !add(set, i - 1, j - 1)  // top left
                            || !add(set, i - 1, j + 1)  // top right
                            || !add(set, i + 1, j - 1)  // bottom left
                            || !add(set, i + 1, j + 1)  // bottom right
                    ) {
                        // duplicates found!
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean add(boolean[] set, int i, int j) {
        if (i < 0 || i >= 9 || j < 0 || j >= 9) {
            return true; // do nothing
        }
        char ch = board[i][j];
        if (ch == '.') {
            return true;
        }
        if (!set[ch - '1']) {
            set[ch - '1'] = true;
            return true;
        } else {
            return false;
        }
    }
}
