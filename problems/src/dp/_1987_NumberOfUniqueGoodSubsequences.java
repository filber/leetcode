package dp;

//https://leetcode.com/problems/number-of-unique-good-subsequences/

public class _1987_NumberOfUniqueGoodSubsequences {

    public int numberOfUniqueGoodSubsequences(String binary) {
        final int modulo = (int) (1e9 + 7);

        char[] chars = binary.toCharArray();
        int n = chars.length;

        int hasZero = 0;
        int start = 0;

        while (start < n && chars[start] == '0') {
            start++;
            hasZero = 1;
        }

        if (start == n) {
            return 1; // all zero
        }

        long[] dp = new long[n];
        dp[start] = 1;
        int lastOne = -1, lastZero = -1;
        for (int i = start + 1; i < n; i++) {
            char ch = chars[i];
            if (ch == '0') {
                if (lastZero == -1) {
                    dp[i] = (2 * dp[i - 1]) % modulo;
                } else {
                    dp[i] = (2 * dp[i - 1] - dp[lastZero - 1] + modulo) % modulo;
                }
                lastZero = i;
                hasZero = 1;
            } else {
                if (lastOne == -1) {
                    dp[i] = (2 * dp[i - 1]) % modulo;
                } else {
                    dp[i] = (2 * dp[i - 1] - dp[lastOne - 1] + modulo) % modulo;
                }
                lastOne = i;
            }
        }

        return (int) ((dp[n - 1] + hasZero) % modulo);
    }
}
