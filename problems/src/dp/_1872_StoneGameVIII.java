package dp;

// https://leetcode.com/problems/stone-game-viii/
public class _1872_StoneGameVIII {

//    There are n stones arranged in a row.
//    On each player's turn, while the number of stones is more than one,
//    they will do the following:
//    Choose an integer x > 1, and remove the leftmost x stones from the row.
//    Add the sum of the removed stones' values to the player's score.
//    Place a new stone, whose value is equal to that sum, on the left side of the row.

    public static int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }

        // dp[i] represent maximum value of {Alice-Bob} when x in [i,n-1]
        // that is dp[i] = max(ps[i]-dp[i+1],ps[i+1]-dp[i+2],....,ps[n-2] - dp[n-1])
        // since  dp[i+1] = max(ps[i+1]-dp[i+2],ps[i+2]-dp[i+3],....,ps[n-2] - dp[n-1])
        // then dp[i] = max(ps[i] - dp[i+1],dp[i+1])
        int[] dp = new int[n + 1];

        // take all stones
        dp[n] = prefixSum[n];
        for (int i = n - 1; i >= 2; i--) {
            dp[i] = Math.max(dp[i + 1], prefixSum[i] - dp[i + 1]);
        }
        return dp[2];
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
