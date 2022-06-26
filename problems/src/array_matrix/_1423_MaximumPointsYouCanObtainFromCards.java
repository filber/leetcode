package array_matrix;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class _1423_MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = cardPoints[i - 1] + prefixSum[i - 1];
        }
        int maxScore = 0;
        for (int rightLen = 0; rightLen <= k; rightLen++) {
            int leftScore = prefixSum[k - rightLen];
            int rigtScore = prefixSum[n] - prefixSum[n - rightLen];
            maxScore = Math.max(maxScore, leftScore + rigtScore);
        }
        return maxScore;
    }
}
