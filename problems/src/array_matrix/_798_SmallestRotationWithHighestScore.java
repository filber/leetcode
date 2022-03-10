package array_matrix;

//https://leetcode.com/problems/smallest-rotation-with-highest-score/

public class _798_SmallestRotationWithHighestScore {
    // For A[i]<=i, earn one point

    public int bestRotation(int[] A) {
        int n = A.length;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            int k = (i - A[i] + 1 + n) % n;
            prefix[k]++;
        }

        int ans = 0;
        for (int k = 1; k < n; k++) {
            prefix[k] += prefix[k - 1] - 1;
            if (prefix[k] < prefix[ans]) {
                ans = k;
            }
        }

        return ans;
    }
}
