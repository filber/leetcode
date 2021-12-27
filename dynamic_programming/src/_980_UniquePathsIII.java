// TOPICS:
// [Backtracking], [Matrix]

// TIPS:
// Backtracking:
// (1) Guard conditions
// (2) Succeed conditions
// (3) Set states
// (4) Recursively backtracking
// (5) Restore states
public class _980_UniquePathsIII {
    private int pathCnt = 0;
    private int[][] grid;
    private int walkableCnt = 0;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        // calculate walkableCnt
        int startX=0,startY=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j]==0) {
                    walkableCnt++;
                }
            }
        }
        backtrack(0, startX-1, startY); // up
        backtrack(0, startX+1, startY); // down
        backtrack(0, startX, startY-1); // left
        backtrack(0, startX, startY+1); // right
        return pathCnt;
    }

    private void backtrack(int cnt, int i, int j) {
        if (i<0 || i>=grid.length || j<0||j>=grid[0].length) {
            return; // illegal position
        }
        if (grid[i][j] == 2 && walkableCnt == cnt) {
            pathCnt++; // succeed
            return;
        }
        if (grid[i][j] != 0) {
            return ; // can not walk
        }

        grid[i][j] = 3; // mark as already walked
        cnt++;

        // iterate four directions
        backtrack(cnt, i - 1, j); // up
        backtrack(cnt, i + 1, j); // down
        backtrack(cnt, i, j - 1); // left
        backtrack(cnt, i, j + 1); // right

        // revert
        cnt--;
        grid[i][j] = 0;
    }

    public static void main(String[] args) {
        int[][] g1 = new int[][] {
                {1,0,2}
        };
        int c1 = new _980_UniquePathsIII().uniquePathsIII(g1); // 1

        int[][] g2 = new int[][] {
                {1,0,2},
                {0,0,-1},
        };
        int c2 = new _980_UniquePathsIII().uniquePathsIII(g2); // 1

        int[][] g3 = new int[][] {
                {0,1},
                {2,0},
        };
        int c3 = new _980_UniquePathsIII().uniquePathsIII(g3); // 0

        int[][] g4 = new int[][] {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1},
        };
        int c4 = new _980_UniquePathsIII().uniquePathsIII(g4); // 2

        int[][] g5 = new int[][] {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,0,2},
        };
        int c5 = new _980_UniquePathsIII().uniquePathsIII(g5); // 4
    }
}
