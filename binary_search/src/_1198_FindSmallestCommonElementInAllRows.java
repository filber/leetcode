public class _1198_FindSmallestCommonElementInAllRows {

//    Given an m x n matrix mat where every row is sorted in strictly increasing order,
//    return the smallest common element in all rows.
//    If there is no common element, return -1.
//
//    Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 500
//    1 <= mat[i][j] <= 104
//    mat[i] is sorted in strictly increasing order.

    public static int findSmallestCommonElement(int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            int target = mat[0][i];
            int count = 1;
            for (int j = 1; j < mat.length; j++) {
                int index = binarySearch(mat[j], 0, mat[j].length, target);
                if (index == -1) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == mat.length) {
                return target;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int startIndex, int endIndex, int target) {
        if (startIndex == endIndex) {
            if (arr[startIndex]==target) {
                return startIndex;
            } else {
                return -1;
            }
        }
        int middleIndex = (startIndex + endIndex) / 2;
        int middleValue = arr[middleIndex];
        if (middleValue == target) {
            return middleIndex;
        } else if (middleValue > target && middleIndex != 0) {
            return binarySearch(arr, startIndex, middleIndex - 1, target);
        } else if (middleValue < target && middleIndex != arr.length - 1) {
            return binarySearch(arr, middleIndex + 1, endIndex, target);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
//        Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
//        Output: 5
        int[][] mat = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        System.out.println(findSmallestCommonElement(mat));

//        Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
//        Output: 2
        mat = new int[][]{{1, 2, 3}, {2, 3, 4}, {2, 3, 5}};
        System.out.println(findSmallestCommonElement(mat));
    }
}
