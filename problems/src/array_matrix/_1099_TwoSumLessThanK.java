package array_matrix;

//https://leetcode.com/problems/two-sum-less-than-k/

import java.util.Arrays;

public class _1099_TwoSumLessThanK {

    // Given an array A of integers and integer K,
    // return the maximum S such that there exists
    // i < j with A[i] + A[j] = S and S < K.
    // If no i, j exist satisfying this equation, return -1.

    // Constraints:
    // A is not ordered.
    // 1 <= A.length <= 100
    // 1 <= A[i] <= 1000
    // 1 <= K <= 2000

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int S = -1;
        int l = 0, r = A.length - 1;
        while (l < r) {
            int sum = A[l] + A[r];
            if (sum >= K) {
                r--;
            } else {
                S = Math.max(S, sum);
                l++;
            }
        }

        return S;
    }
}
