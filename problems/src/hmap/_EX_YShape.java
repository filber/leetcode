package hmap;

import java.util.Map;

public class _EX_YShape {

    int[][] yShape(int[][] matrix) {
        int n = matrix.length;
        int[] yCount = new int[3];
        int[] oCount = new int[3];
        int yTotal = n + n / 2;
        int oTotal = n * n - yTotal;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (isOnY(n, i, j)) {
                    yCount[val]++;
                } else {
                    oCount[val]++;
                }
            }
        }

        int minChanges = Integer.MAX_VALUE;
        int yVal = 0;
        int oVal = 0;
        for (int i = 0; i < 3; i++) {
            int yChanges = yTotal - yCount[i];
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                int oChanges = oTotal - oCount[j];
                if (yChanges + oChanges < minChanges) {
                    yVal = i;
                    oVal = j;
                    minChanges = yChanges + oChanges;
                }
            }
        }

        int[][] rst = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isOnY(n, i, j)) {
                    rst[i][j] = yVal;
                } else {
                    rst[i][j] = oVal;
                }
            }
        }

        return rst;
    }

    boolean isOnY(int n, int i, int j) {
        if (i < n / 2) {
            return i == j || (i + j == (n - 1));
        } else {
            return j == n / 2;
        }
    }
}
