package ps;

//https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/

import java.util.HashMap;
import java.util.Map;

public class _1074_NumberOfSubmatricesThatSumToTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
            }
        }

        for (int c1 = 1; c1 <= n; c1++) {
            for (int c2 = c1; c2 <= n; c2++) {
                map.clear();
                map.put(0, 1);
                int sum = 0;
                for (int r = 0; r < m; r++) {
                    sum += prefixSum[r][c2] - prefixSum[r][c1 - 1];
                    ans += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }

}
