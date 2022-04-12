package array_matrix;

//https://leetcode.com/problems/game-of-life/

public class _289_GameOfLife {

    public void gameOfLife(int[][] board) {
        int[][] direction = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCnt = 0;
                for (int k = 0; k < direction.length; k++) {
                    int x = i + direction[k][0];
                    int y = j + direction[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        liveCnt += board[x][y] & 1;
                    }
                }

                if ((board[i][j] & 1) == 1) {
                    if (liveCnt == 2 || liveCnt == 3) {
                        // lives for next generation
                        board[i][j] = board[i][j] | 2;
                    }
                } else {
                    if (liveCnt == 3) {
                        // lives for next generation
                        board[i][j] = board[i][j] | 2;
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
