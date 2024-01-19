package dp;

//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/

public class _1359_CountAllValidPickupAndDeliveryOptions {

    public int countOrders(int n) {
        final int modulo = (int) (1e9 + 7);
        // dp[i]: how many ways to permute i orders
        long[] dp = new long[n + 1];
        dp[1] = 1L;
        long slots = 2L * n;
        for (int i = 2; i <= n; i++) {
            long valid_choices = (slots * (slots - 1)) / 2;
            dp[i] = (dp[i - 1] * valid_choices) % modulo;
            slots -= 2;
        }
        return (int) dp[n];
    }
}
