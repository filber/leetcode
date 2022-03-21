package dp;

//https://leetcode.com/problems/distinct-subsequences-ii/

public class _940_DistinctSubsequencesII {

    public int distinctSubseqII(String s) {
        long modulo = (long) (1e9 + 7);
        int[] lastPos = new int[26];
        char[] chars = s.toCharArray();
        int n = chars.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char ch = chars[i - 1];
            int lastIdx = lastPos[ch - 'a'];
            if (lastIdx == 0) {
                dp[i] = (dp[i - 1] * 2) % modulo;
            } else {
                dp[i] = (dp[i - 1] * 2 - dp[lastIdx - 1] + modulo) % modulo;
            }
            lastPos[ch - 'a'] = i;
        }
        return (int) (dp[n] - 1);
    }
}
