package dp;

// https://leetcode.com/problems/stone-game-viii/
public class _1872_StoneGameVIII {

    public static int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] dp = new int[n];
        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        dp[n - 1] = prefixSum[n - 1];

        //dp[i], max relative score of choosing [i,n-1]
        for (int i = n - 2; i > 0; --i) {
            dp[i] = Math.max(dp[i + 1], prefixSum[i] - dp[i + 1]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        // 5
        int d1 = stoneGameVIII(new int[]{-1, 2, -3, 4, -5});
        // 13
        int d2 = stoneGameVIII(new int[]{7, -6, 5, 10, 5, -2, -6});
        // -22
        int d3 = stoneGameVIII(new int[]{-10, -12});
    }
}
