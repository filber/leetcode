package bs;
//https://leetcode.com/problems/search-a-2d-matrix/

// TIPS: Using bottom left corner to shrink the matrix
// Move upwards or right
public class _240_SearchA2DMatrixII {

//    Constraints:
//        m == matrix.length
//        n == matrix[i].length
//        1 <= n, m <= 300
//        -109 <= matrix[i][j] <= 109
//        All the integers in each row are sorted in ascending order.
//        All the integers in each column are sorted in ascending order.
//        -109 <= target <= 109
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return searchMatrix(matrix, target, 0, 0, m - 1, n - 1);
    }

    public static boolean searchMatrix(int[][] matrix, int target,
                                       int upperLeftX, int upperLeftY,
                                       int bottomRightX, int bottomRightY) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 0. Guard conditions
        if (upperLeftX<0 ||upperLeftX>=m ||
            bottomRightY<0 ||bottomRightY>=n ||
            upperLeftX > bottomRightX || upperLeftY > bottomRightY
            ) {
            return false;
        }
        // exceed limits
        else if (target< matrix[upperLeftX][upperLeftY] ||// less than min
                target > matrix[bottomRightX][bottomRightY]) { // greater than max
            return false;
        }

        // 3. Compare to the bottom left corner value
        int cornerValue = matrix[bottomRightX][upperLeftY];
        if (cornerValue == target) {
            return true;
        } else if (target < cornerValue) {
            // move upwards
            return searchMatrix(matrix, target, upperLeftX, upperLeftY, bottomRightX - 1, bottomRightY);
        } else {
            // move to the right
            return searchMatrix(matrix, target, upperLeftX, upperLeftY + 1, bottomRightX, bottomRightY);
        }
    }

    public static void main(String[] args) {
        int[][] m4 = new int[][]{
                {1}};
        boolean r4_1 = searchMatrix(m4,1); // found
        boolean r4_2 = searchMatrix(m4,2); // not found

        int[][] m5 = new int[][]{
                {1,2},{3,4}};
        boolean r5_1 = searchMatrix(m5,2); // found
        boolean r5_2 = searchMatrix(m4,5); // not found

        int[][] m2 = new int[][]{
                {1, 4, 7, 11, 15}};
        boolean r2_1 = searchMatrix(m2,4); // found
        boolean r2_2 = searchMatrix(m2,20); // not found

        int[][] m3 = new int[][]{
                {1}, {4}, {7}, {11}, {15}};
        boolean r3_1 = searchMatrix(m3,11); // found
        boolean r3_2 = searchMatrix(m3,20); // not found

        int[][] m1 = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        boolean r1_1 = searchMatrix(m1,5); // found
        boolean r1_2 = searchMatrix(m1,20); // not found
        boolean r1_3 = searchMatrix(m1,0); // not found
        boolean r1_4 = searchMatrix(m1,31); // not found
        boolean r1_5 = searchMatrix(m1,1); // found
        boolean r1_6 = searchMatrix(m1,15); // found
        boolean r1_7 = searchMatrix(m1,18); // found
        boolean r1_8 = searchMatrix(m1,30); // found
        boolean r1_9 = searchMatrix(m1,3); // found
        boolean r1_10 = searchMatrix(m1,11); // found
        boolean r1_11 = searchMatrix(m1,23); // found
        boolean r1_12 = searchMatrix(m1,22); // found
    }
}
