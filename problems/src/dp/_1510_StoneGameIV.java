package dp;

// https://leetcode.com/problems/stone-game-iv/
public class _1510_StoneGameIV {

    public static boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            boolean canWin = false;
            for (int k = 1; k * k <= n && (i - k * k) >= 0; k++) {
                if (dp[i - k*k] == false) {
                    canWin = true;
                    break;
                }
            }
            dp[i] = canWin;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // [1->0]
        boolean b1 = winnerSquareGame(1); // true

        // [2->1->0]
        boolean b2 = winnerSquareGame(2); // false

        // [3->2->1->0]
        boolean b3 = winnerSquareGame(3); // true

        // [4->0]
        boolean b4 = winnerSquareGame(4); // true
    }
}
