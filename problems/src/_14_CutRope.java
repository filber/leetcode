public class _14_CutRope {

    public static int cutRope(int n) {
        if (n < 2) {
            return 0;
        } else if (n==2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // pay attention! why 3 is different
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        cutRope(8);
    }
}
