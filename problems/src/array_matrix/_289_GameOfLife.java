package array_matrix;

//https://leetcode.com/problems/game-of-life/

public class _289_GameOfLife {

    static final int[][] direction = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighborLiveCnt = 0;
                for (int k = 0; k < 8; k++) {
                    int neighborI = direction[k][0] + i;
                    int neighborJ = direction[k][1] + j;
                    if (0 <= neighborI && neighborI < m && 0 <= neighborJ && neighborJ < n) {
                        neighborLiveCnt += board[neighborI][neighborJ] & 1;
                    }
                }
                if ((board[i][j] & 1) == 1) {
                    if (neighborLiveCnt < 2) {
                        // next state die
                    } else if (neighborLiveCnt == 2 || neighborLiveCnt == 3) {
                        // next state live
                        board[i][j] |= 2;
                    } else if (neighborLiveCnt > 3) {
                        // next state die
                    }
                } else {
                    if (neighborLiveCnt == 3) {
                        // next state live
                        board[i][j] |= 2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
