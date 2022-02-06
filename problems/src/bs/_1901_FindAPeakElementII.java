package bs;

// https://leetcode.com/problems/find-a-peak-element-ii/

public class _1901_FindAPeakElementII {

    // O(m log(n)) or O(n log(m))
    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (m < n) {
            return findPeakGrid(mat, true, 0, n - 1);
        } else {
            return findPeakGrid(mat, false, 0, m - 1);
        }
    }

    public static int[] findPeakGrid(int[][] mat, boolean splitByCol, int start, int end) {
        int m = mat.length;
        int n = mat[0].length;
        int mid = (start + end) / 2;

        int max = Integer.MIN_VALUE;
        int maxI = 0;
        int maxJ = 0;

        int len = splitByCol ? m : n;
        for (int i = 0; i < len; i++) {
            int top;
            if (splitByCol) {
                top = mid == 0 ? -1 : mat[i][mid - 1];
            } else {
                top = mid == 0 ? -1 : mat[mid - 1][i];
            }

            if (top > max) {
                max = top;
                maxI = i;
                maxJ = mid - 1;
            }

            int middle = splitByCol ? mat[i][mid] : mat[mid][i];
            if (middle > max) {
                max = middle;
                maxI = i;
                maxJ = mid;
            }

            int bottom;
            if (splitByCol) {
                bottom = mid == n - 1 ? -1 : mat[i][mid + 1];
            } else {
                bottom = mid == m - 1 ? -1 : mat[mid + 1][i];
            }
            if (bottom > max) {
                max = bottom;
                maxI = i;
                maxJ = mid + 1;
            }
        }

        if (maxJ == mid) {
            return splitByCol ? new int[]{maxI, maxJ} : new int[]{maxJ, maxI};
        } else if (maxJ == mid - 1) {
            return findPeakGrid(mat, splitByCol, start, mid - 1);
        } else {
            return findPeakGrid(mat, splitByCol, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        // 4 (0,1)
        // 3 (1,0)
        int[] m1 = findPeakGrid(new int[][]{
                {1, 4},
                {3, 2}});

        // 30 (1,1)
        // 32 (2,2)
        int[] m2 = findPeakGrid(new int[][]{
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}});

        // 30 (1,1)
        // 32 (2,2)
        int[] m3 = findPeakGrid(new int[][]{
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32},
                {1, 2, 3}});

        int[] m4 = findPeakGrid(new int[][]{
                {11, 77, 6, 56, 95, 42, 78, 33, 4, 12, 30, 87, 74, 76, 3, 98},
                {87, 35, 74, 6, 98, 97, 23, 61, 67, 84, 57, 36, 24, 75, 56, 82},
                {63, 12, 61, 45, 53, 43, 42, 86, 14, 21, 43, 53, 89, 64, 37, 85},
                {52, 98, 71, 5, 59, 12, 41, 33, 42, 15, 99, 52, 66, 1, 85, 70},
                {60, 53, 7, 25, 67, 47, 80, 97, 64, 81, 57, 98, 7, 27, 35, 71},
                {17, 37, 57, 90, 63, 16, 4, 81, 78, 31, 91, 21, 40, 71, 2, 53},
                {12, 29, 15, 60, 16, 83, 20, 64, 92, 38, 66, 91, 35, 54, 62, 61},
                {32, 59, 71, 19, 50, 25, 77, 66, 96, 18, 9, 36, 99, 44, 65, 35},
                {1, 37, 93, 39, 76, 75, 85, 63, 20, 58, 69, 62, 45, 43, 71, 98},
                {70, 49, 59, 42, 25, 90, 31, 74, 50, 30, 100, 53, 6, 41, 96, 61},
                {91, 50, 85, 84, 20, 64, 5, 17, 65, 76, 43, 13, 57, 13, 68, 59},
                {2, 93, 19, 53, 84, 20, 10, 61, 34, 44, 80, 89, 51, 84, 11, 43},
                {87, 69, 49, 41, 81, 92, 98, 63, 70, 5, 9, 31, 81, 88, 37, 30},
                {96, 12, 56, 13, 98, 82, 91, 13, 57, 22, 89, 39, 4, 6, 42, 8},
                {38, 46, 48, 56, 19, 32, 68, 53, 73, 88, 24, 22, 23, 11, 79, 49},
                {80, 88, 31, 64, 75, 19, 30, 60, 82, 33, 59, 33, 86, 2, 60, 37},
                {87, 70, 21, 10, 57, 45, 76, 39, 55, 89, 33, 59, 39, 26, 50, 62}});

        int[] m5 = findPeakGrid(new int[][]
                {{1, 2, 3, 4, 5, 6, 7, 8},
                        {2, 3, 4, 5, 6, 7, 8, 9},
                        {3, 4, 5, 6, 7, 8, 9, 10},
                        {4, 5, 6, 7, 8, 9, 10, 11}});
    }
}
