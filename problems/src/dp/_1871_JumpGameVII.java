package dp;

// https://leetcode.com/problems/jump-game-vii/

public class _1871_JumpGameVII {

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (chars[n - 1] == '1') {
            return false;
        }
        int[] dp = new int[n];
        int[] prefixSum = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + dp[i - 1];
            if (chars[i] == '0') {
                int l = Math.max(0, i - maxJump);
                int r = i - minJump;
                if (l <= r && (prefixSum[r + 1] - prefixSum[l]) > 0) {
                    // reachable
                    dp[i] = 1;
                }
            }
        }
        return dp[n - 1] == 1;
    }

    public static void main(String[] args) {
        boolean b1 = canReach("011010", 2, 3); // true
        boolean b2 = canReach("01101110", 2, 3); // false
        boolean b3 = canReach("0000000000", 8, 8); // false
        boolean b4 = canReach("00", 1, 1); // true
    }
}
