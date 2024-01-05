package dp;

//https://leetcode.com/problems/decode-ways/

public class _91_DecodeWays {

    // A-1, B-2, C-3, D-4, E-5, F-6, G-7, H-8, I-9,
    // J-10, K-11, L-12, M-13, N-14, O-15, P-16, Q-17, R-18, S-19,
    // T-20, U-21, V-22, W-23, X-24, Y-25, Z-26
    public int numDecodings(String s) {
        char[] A = s.toCharArray();
        if (A[0] == '0') {
            return 0;
        }

        int n = A.length;
        // dp[i]: ways to decode s[0..i]
        int[] dp = new int[n + 1];

        dp[0] = 1; // empty
        dp[1] = 1; // first char
        for (int i = 2; i <= n; i++) {
            char cur = A[i - 1];
            char previous = A[i - 2];
            if (cur == '0' && previous != '1' && previous != '2') {
                return 0;
            } else if (cur == '0' && (previous == '1' || previous == '2')) {
                dp[i] = dp[i - 2];
            } else if (cur >= '7' && cur <= '9' && previous == '1') {
                dp[i] = dp[i - 1] + dp[i - 2]; // could combine with previous '1' or exist singly
            } else if (cur >= '7' && cur <= '9') {
                dp[i] = dp[i - 1]; // can't combine with previous char
            } else if (cur >= '1' && cur <= '6' && (previous == '1' || previous == '2')) {
                dp[i] = dp[i - 1] + dp[i - 2]; // could combine with previous '1'/'2' or exist singly
            } else {
                dp[i] = dp[i - 1]; // can't combine with previous char
            }
        }
        return dp[n];
    }
}
