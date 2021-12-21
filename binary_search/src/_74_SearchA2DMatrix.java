public class _74_SearchA2DMatrix {

//    Constraints:
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 100
//        -104 <= matrix[i][j], target <= 104
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 1. init m,n
        int m = matrix.length;
        int n = matrix[0].length;

        // 2. binary search in the first column
        int rowIndex = binarySearchInFirstColumn(matrix, target, 0, m - 1);
        if (rowIndex == -1) {
            return false;
        }

        // 3. binary search in that row
        int colIndex = binarySearchInRow(matrix[rowIndex], target, 0, n - 1);
        if (colIndex == -1) {
            return false;
        } else {
            return true;
        }
    }


    private static int binarySearchInFirstColumn(
            int[][] matrix, int target, int start, int end) {
        // 0. Guard conditions
        if (start < 0 || end >= matrix.length || start > end) {
            return -1; // not found
        } else if (start == end) {
            return start; // one row
        }

        // 1. binary search
        int middleIndex = (start + end) / 2;
        int middleValue = matrix[middleIndex][0];
        // 1.1. found in the middle row!
        if (middleValue <= target && target < matrix[middleIndex + 1][0]) {
            return middleIndex;
        }
        // 1.2. binary search in the upper part
        else if (target < middleValue) {
            return binarySearchInFirstColumn(matrix, target, start, middleIndex - 1);
        }
        // 1.3. binary search in the lower part
        else {
            return binarySearchInFirstColumn(matrix, target, middleIndex + 1, end);
        }
    }

    private static int binarySearchInRow(
            int[] nums, int target, int start, int end) {
        // 0. Guard conditions
        if (start < 0 || end >= nums.length || start > end) {
            return -1; // not found
        } else if (start == end) {
            // just one element
            return target == nums[start] ? start : -1;
        }

        // 1. Binary search
        int middleIndex = (start+end)/2;
        int middleValue = nums[middleIndex];
        // 1.1. Found in the middle!
        if (middleValue==target) {
            return middleIndex;
        }
        // 1.1. Search in the left part
        else if (target < middleValue) {
            return binarySearchInRow(nums, target, start, middleIndex - 1);
        }
        // 1.2. Search in the right part
        else{
            return binarySearchInRow(nums, target, middleIndex + 1, end);
        }
    }

    public static void main(String[] args) {
        // normal
        int[][] m1 = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean r1_1 = searchMatrix(m1, 3); // found
        boolean r1_2 = searchMatrix(m1, 13); // not found
        boolean r1_3 = searchMatrix(m1, 0); // not found
        boolean r1_4 = searchMatrix(m1, 61); // not found

        // one row
        int[][] m2 = new int[][]{{1, 3, 5, 7}};
        boolean r2_1 = searchMatrix(m2, 3); // found
        boolean r2_2 = searchMatrix(m2, -1); // not found
        boolean r2_3 = searchMatrix(m2, 10); // not found
        boolean r2_4 = searchMatrix(m2, 4); // not found

        // one column
        int[][] m3 = new int[][]{{1}, {3}, {5}, {7}};
        boolean r3_1 = searchMatrix(m3, 3); // found
        boolean r3_2 = searchMatrix(m3, -1); // not found
        boolean r3_3 = searchMatrix(m3, 10); // not found
        boolean r3_4 = searchMatrix(m3, 4); // not found
    }
}
