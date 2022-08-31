package ps;

//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

import java.util.*;

public class _363_MaxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ps = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = ps[i][j - 1] + matrix[i][j - 1];
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        int maxSum = Integer.MIN_VALUE;
        for (int c1 = 1; c1 <= n; c1++) {
            for (int c2 = c1; c2 <= n; c2++) {
                set.clear();
                set.add(0);
                int sum = 0;
                for (int r = 0; r < m; r++) {
                    sum += ps[r][c2] - ps[r][c1 - 1];
                    Integer ceil = set.ceiling(sum - k);
                    if (ceil != null) {
                        maxSum = Math.max(maxSum, sum - ceil);
                    }
                    set.add(sum);
                }
            }
        }
        return maxSum;
    }
}
