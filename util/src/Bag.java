public class Bag {

    public static int solveOneZero2D(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int notPut = dp[i-1][j];
                int put = 0;
                int w = weight[i-1];
                int v = value[i - 1];
                if (w <= j) {
                    // has sufficient room
                    put = dp[i - 1][j - w] + v;
                }
                dp[i][j] = Math.max(notPut,put);
            }
        }

        return dp[n][capacity];
    }

    public static int solveOneZero1D(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            // loop j from right to left, need old values in dp[j - w]!
            for (int j = capacity; j > 0; j--) {
                int notPut = dp[j];
                int w = weight[i];
                int v = value[i];
                int put = 0;
                if (j>=w) {
                    put = dp[j - w] + v;
                }
                dp[j] = Math.max(notPut, put);
            }
        }
        return dp[capacity];
    }

    public static int solveComplete2D(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= capacity; j++) {
                int w = weight[i-1];
                int v = value[i-1];
                int notPut = dp[i-1][j];
                int put = 0;
                if (j >= w) {
                    put = dp[i][j - w] + v;
                }
                dp[i][j] = Math.max(notPut, put);
            }
        }

        return dp[n][capacity];
    }

    public static int solveComplete1D(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <n ; i++) {
            // loop j from left to right, just need new values in dp[j - w]
            for (int j = 1; j <= capacity; j++) {
                int w = weight[i];
                int v = value[i];
                int notPut = dp[j];
                int put = 0;
                if (j >= w) {
                    put = dp[j - w] + v;
                }
                dp[j] = Math.max(notPut, put);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        // 0-1 Bag: Just have one item for each type
        int[] weight = new int[]{2, 3, 4, 5};
        int[] value = new int[]{3, 4, 5, 6};
        // weight = 3 + 5 = 8
        // value = 4 + 6 = 10
        int n1 = solveOneZero1D(weight, value, 8); // 10

        // Complete Bag: Have infinite items for each type
        weight = new int[]{2, 3, 4, 7};
        value = new int[]{1, 3, 5, 9};
        // weight = 3 + 7 = 10
        // value = 3 + 9 = 12
        int n2 = solveComplete1D(weight, value, 10);
    }
}
