package array_matrix;

import java.util.PriorityQueue;

public class _1329_SortTheMatrixDiagonally {


    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] rst = new int[m][n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // n + m - 1
        for (int k = -m + 1; k < n; k++) {
            int startI, startJ;
            if (k >= 0) {
                startI = 0;
                startJ = k;
            } else {
                startI = -k;
                startJ = 0;
            }
            pq.clear();
            int i = startI, j = startJ;
            while (i < m && j < n) {
                pq.add(mat[i][j]);
                i++;
                j++;
            }
            i = startI;
            j = startJ;
            while (!pq.isEmpty()) {
                rst[i][j] = pq.poll();
                i++;
                j++;
            }
        }
        return rst;
    }
}
