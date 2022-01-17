package array_matrix;

// https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

public class _1198_FindSmallestCommonElementInAllRows {

    //    Given an m x n matrix mat where every row is sorted in strictly increasing order,
//    return the smallest common element in all rows.
//    If there is no common element, return -1.
//    Constraints:
    //    m == mat.length
    //    n == mat[i].length
    //    1 <= m, n <= 500
    //    1 <= mat[i][j] <= 10^4
    //    mat[i] is sorted in strictly increasing order.
    public static int findSmallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (m == 1) {
            return mat[0][0];
        }

        for (int i = 0; i < n; i++) {
            int val = mat[0][i];
            int matchedRowCnt = 0;

            for (int j = 1; j < m; j++) {
                if (bs(mat[j], 0, n, val) == -1) {
                    break;
                } else {
                    matchedRowCnt++;
                }
            }

            if (matchedRowCnt == m - 1) {
                return val;
            }
        }

        return -1;
    }

    public static int bs(int[] arr, int start, int end, int val) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midVal = arr[mid];
        if (midVal < val) {
            return bs(arr, mid + 1, end, val);
        } else if (midVal > val) {
            return bs(arr, start, mid - 1, val);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        // 5
        int s1 = findSmallestCommonElement(new int[][]{
                {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9}
        });

        // 2
        int s2 = findSmallestCommonElement(new int[][]{
                {1, 2, 3},
                {2, 3, 4},
                {2, 3, 5}
        });

        // -1
        int s3 = findSmallestCommonElement(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {6, 7, 8}
        });
    }
}
