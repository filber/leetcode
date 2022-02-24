package array_matrix;

//https://leetcode.com/problems/where-will-the-ball-fall/

public class _1706_WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            int idx = j;
            for (int i = 0; i < m; i++) {
                int gVal = grid[i][idx];
                int nextIdx = idx + gVal;
                if (nextIdx < 0 ||
                        nextIdx == n ||
                        gVal != grid[i][idx + gVal]
//                        gVal == 1 && grid[i][idx + 1] == -1 ||
//                        gVal == -1 && grid[i][idx - 1] == 1
                ) {
                    idx = -1;
                    break;
                } else {
                    idx = nextIdx;
                }
            }
            ans[j] = idx;
        }

        return ans;
    }
}
