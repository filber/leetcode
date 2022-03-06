package dp;

//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/

public class _1359_CountAllValidPickupAndDeliveryOptions {

    public int countOrders(int n) {
        final int modulo = (int) (1e9 + 7);
        int sum = 1;
        long dp = 1;

        for (int i = 2; i <= n; i++) {
            sum = sum + 4 * i - 3;
            dp = (sum * dp) % modulo;
        }

        return (int) dp;
    }
}
