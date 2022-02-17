package dp;
// https://leetcode.com/problems/divisor-game/

public class _1025_DivisorGame {

    // Makes a move consisting of:
    //  Choosing any x with 0 < x < n and n % x == 0.
    //  Replacing the number n on the chalkboard with n - x.
    public static boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static boolean divisorGameDP(int n) {
        if (n == 1) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (dp[i - j] == false && (i % j) == 0) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        boolean b1 = divisorGame(1); // false
        boolean b2 = divisorGame(2); // true
        boolean b3 = divisorGame(3); // false
        boolean b4 = divisorGame(4); // true
    }
}
