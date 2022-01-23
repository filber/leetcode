package dp;

// https://leetcode.com/problems/stone-game-iii/

public class _1406_StoneGameIII {

    // Alice and Bob take turns, with Alice starting first.
    // On each player's turn, that player can take 1, 2, or 3
    // stones from the first remaining stones in the row.

    // Constraints:
    //      1 <= stoneValue.length <= 5 * 10^4
    //      -1000 <= stoneValue[i] <= 1000
    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        int sum = 0;

        for (int i = n - 1; i >= 0; i--) {
            sum += stoneValue[i];
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= 3 && i + j <= n; j++) {
                max = Math.max(max, sum - dp[i + j]);
            }
            dp[i] = max;
        }

        int aliceScore = dp[0];
        int bobScore = sum - aliceScore;
        if (aliceScore == bobScore) {
            return "Tie";
        } else if (aliceScore > bobScore) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public static void main(String[] args) {
        String p1 = stoneGameIII(new int[]{1, 2, 3, 7});
        String p2 = stoneGameIII(new int[]{1, 2, 3, -9});
        String p3 = stoneGameIII(new int[]{1, 2, 3, 6});
    }
}
