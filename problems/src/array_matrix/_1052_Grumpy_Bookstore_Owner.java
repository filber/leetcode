package array_matrix;

// https://leetcode.com/problems/grumpy-bookstore-owner/

import java.util.Map;

//[Sliding Window],[Prefix Sum]
public class _1052_Grumpy_Bookstore_Owner {

    public static int maxSatisfied(int[] customers, int[] grumpy, int m) {
        int n = customers.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = grumpy[0] == 0 ? customers[0] : 0;
        for (int i = 1; i < n; i++) {
            if (grumpy[i] == 0) {
                prefixSum[i] = prefixSum[i - 1] + customers[i];
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        int maxSatisfied = 0;
        int leftSum = 0;
        int winSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n && i + m - 1 < n; i++) {
            if (i == 0) {
                leftSum = 0;
                for (int j = 0; j < m; j++) {
                    winSum += customers[j];
                }
                rightSum = prefixSum[n - 1] - prefixSum[m - 1];
            } else {
                leftSum = prefixSum[i-1];
                winSum -= customers[i-1];
                winSum += customers[i + m - 1];
                rightSum = prefixSum[n - 1] - prefixSum[i + m - 1];
            }
            maxSatisfied = Math.max(maxSatisfied, leftSum + winSum + rightSum);
        }

        return maxSatisfied;
    }

    public static void main(String[] args) {
        int m1 = maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1},
                3);
        int m2 = maxSatisfied(
                new int[]{1},
                new int[]{0},
                1);
    }
}
