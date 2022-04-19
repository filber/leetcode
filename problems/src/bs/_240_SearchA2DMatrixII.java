package bs;

//https://leetcode.com/problems/search-a-2d-matrix-ii/

public class _240_SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int x1 = 0, y1 = 0, x2 = m - 1, y2 = n - 1;

        while (true) {
            if (y1 == n || x2 < 0) {
                break;
            } else if (target < matrix[x1][y1] || target > matrix[x2][y2]) {
                break;
            } else {
                int val = matrix[x2][y1];
                if (val == target) {
                    return true;
                } else if (val < target) {
                    y1++;
                } else {
                    x2--;
                }
            }
        }
        return false;
    }
}
