package dp;

//https://leetcode.com/problems/number-of-unique-good-subsequences/

public class _1987_NumberOfUniqueGoodSubsequences {

    public int numberOfUniqueGoodSubsequences(String binary) {
        final int modulo = (int) (1e9 + 7);

        char[] chars = binary.toCharArray();
        int n = chars.length;
        int dp0 = 0, dp1 = 0, zero = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = chars[i];
            if (ch == '0') {
                zero = 1;
                dp0 = (dp0 + dp1 + 1) % modulo; // update dp0
            } else {
                dp1 = (dp0 + dp1 + 1) % modulo; // update dp1
            }
        }

        return (dp1 + zero) % modulo;
    }
}
