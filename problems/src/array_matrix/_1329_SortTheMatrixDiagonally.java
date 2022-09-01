package array_matrix;

public class _1329_SortTheMatrixDiagonally {


    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int j = 1 - m; j < n; j++) {
            int startI, startJ;
            if (j < 0) {
                startI = -j;
                startJ = 0;
            } else {
                startI = 0;
                startJ = j;
            }
            sort(mat, startI, startJ);
        }

        return mat;
    }

    private void sort(int[][] mat, int startI, int startJ) {
        int[] bucket = new int[101];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = startI, j = startJ;
        while (i < mat.length && j < mat[0].length) {
            int val = mat[i][j];
            bucket[val]++;
            min = Math.min(min, val);
            max = Math.max(max, val);
            i++;
            j++;
        }
        i = startI;
        j = startJ;
        int idx = min;
        while (i < mat.length && j < mat[0].length) {
            while (bucket[idx] == 0) {
                idx++;
            }
            mat[i][j] = idx;
            i++;
            j++;
            bucket[idx]--;
        }
    }
}
