package dfs;

//https://leetcode.com/problems/sudoku-solver/

public class _37_SudokuSolver {

    // A sudoku solution must satisfy all of the following rules:
    //    Each of the digits 1-n must occur exactly once in each row.
    //    Each of the digits 1-n must occur exactly once in each column.
    //    Each of the digits 1-n must occur exactly once in each of the n 3x3 sub-boxes of the grid.

    // Constraints:
    //    board.length == n
    //    board[i].length == n
    //    board[i][j] is a digit or '.'.
    //    It is guaranteed that the input board has only one solution.

    private int m;
    private int n;
    private char[][] board;
    private boolean[][] rowCandidate;
    private boolean[][] colCandidate;
    private boolean[][][] boxCandidate;
    private int[][] emptyLocations;
    private int emptyCnt;

    public void solveSudoku(char[][] board) {

        this.board = board;
        m = board.length;
        n = board[0].length;
        rowCandidate = new boolean[m][9];
        colCandidate = new boolean[n][9];
        boxCandidate = new boolean[m / 3][n / 3][9];
        emptyLocations = new int[m * n][2];
        emptyCnt = 0;

        // 1. Traverse for candidates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    rowCandidate[i][ch - '1'] = true;
                    colCandidate[j][ch - '1'] = true;
                    boxCandidate[i / 3][j / 3][ch - '1'] = true;
                } else {
                    emptyLocations[emptyCnt][0] = i;
                    emptyLocations[emptyCnt][1] = j;
                    emptyCnt++;
                }
            }
        }

        // 2. Backtracking from (0,0)
        boolean res = backtracking(0);
    }

    private boolean backtracking(int pos) {
        if (pos == emptyCnt) {
            return true;
        }
        int i = emptyLocations[pos][0];
        int j = emptyLocations[pos][1];

        // 1. Retrieve candidate for (i,j)
        boolean[] rowCand = rowCandidate[i];
        boolean[] colCand = colCandidate[j];
        boolean[] boxCand = boxCandidate[i / 3][j / 3];

        // 2. Traverse all candidates and backtrack next 2 positions
        for (int k = 0; k < 9; k++) {
            // intersect with boolean bitwise operations
            boolean inter = !rowCand[k] && !colCand[k] && !boxCand[k];
            if (!inter) {
                continue;
            }

            // Set states
            board[i][j] = (char) ('1' + k); // update board
            // update candidate
            rowCand[k] = true;
            colCand[k] = true;
            boxCand[k] = true;
            if (backtracking(pos + 1)) {
                return true;
            } else {
                // Reverse states
                board[i][j] = '.';
                rowCand[k] = false;
                colCand[k] = false;
                boxCand[k] = false;
            }
        }

        // 3. No valid candidates found
        return false;
    }
}
