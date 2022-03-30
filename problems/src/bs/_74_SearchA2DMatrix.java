package bs;

//https://leetcode.com/problems/search-a-2d-matrix/

public class _74_SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (target >= matrix[mid][0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        if (target < matrix[l][0] || target > matrix[r][n - 1]) {
            return false;
        }

        if (target < matrix[r][0]) {
            // search in row L
            return searchRow(matrix[l], target);
        } else {
            // search in row R
            return searchRow(matrix[r], target);
        }
    }

    private boolean searchRow(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == row[mid]) {
                return true;
            } else if (target > row[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
