package array_matrix;

//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.Arrays;

public class _1337_TheKWeakestRowsInAMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] rows = new int[m][2];

        for (int i = 0; i < m; i++) {
            rows[i][0] = i;
            for (int j = 0; j < n; j++) {
                rows[i][1] += mat[i][j];
            }
        }

        Arrays.sort(rows, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = rows[i][0];
        }
        return ans;
    }
}
