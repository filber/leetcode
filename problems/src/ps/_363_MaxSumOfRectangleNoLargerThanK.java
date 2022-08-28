package ps;

import java.util.*;

public class _363_MaxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for (int c1 = 1; c1 <= n; c1++) {
            for (int c2 = c1; c2 <= n; c2++) {
                set.clear();
                set.add(0);
                int sum = 0;
                for (int r = 0; r < m; r++) {
                    sum += prefixSum[r][c2] - prefixSum[r][c1 - 1];
                    Integer ceiling = set.ceiling(sum - k);
                    if (ceiling != null) {
                        max = Math.max(max, sum - ceiling);
                    }
                    set.add(sum);
                }
            }
        }
        return max;
    }
}
