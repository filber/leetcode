package dp;

//https://leetcode.com/problems/distinct-subsequences-ii/

public class _940_DistinctSubsequencesII {

    public int distinctSubseqII(String s) {
        long modulo = (long) (1e9 + 7);
        char[] chars = s.toCharArray();
        int n = chars.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int[] lastIdx = new int[26];
        for (int i = 1; i <= n; i++) {
            int idx = chars[i - 1] - 'a';
            int j = lastIdx[idx];
            if (j == 0) {
                dp[i] = (dp[i - 1] << 1) % modulo;
            } else {
                dp[i] = ((dp[i - 1] << 1) - dp[j - 1] + modulo) % modulo;
            }
            lastIdx[idx] = i;
        }

        return (int) (dp[n] - 1);
    }
}
