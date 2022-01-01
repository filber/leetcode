//TOPICS:
//[Depth-First Search],[Dynamic Programming]

public class _312_BurstBalloons {

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int start = 0; start < n; start++) {
                int end = start + l - 1;
                int maxProduct = 0;
                if (end >= n) {
                    break; // end outside of the bound
                }
                if (start == end) {
                    // one element
                    int left = start == 0 ? 1 : nums[start - 1];
                    int right = end == n - 1 ? 1 : nums[end + 1];
                    maxProduct = left * nums[start] * right;
                } else {
                    for (int k = start; k <= end; k++) {
                        int leftProduct = k == start ? 0 : dp[start][k - 1];
                        int rightProduct = k == end ? 0 : dp[k + 1][end];
                        int kLeft = start == 0 ? 1 : nums[start - 1];
                        int kRight = end == n - 1 ? 1 : nums[end + 1];
                        int kProduct = leftProduct + kLeft * nums[k] * kRight + rightProduct;
                        maxProduct = kProduct > maxProduct ? kProduct : maxProduct;
                    }
                }

                dp[start][end] = maxProduct;
            }
        }

        return dp[0][n - 1];
    }

    public static int maxCoinsDFS(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 1, 1);
    }

    // Time Complexity O(2^n)
    public static int dfs(int[] nums, int from, int to, int left, int right) {
        if (from > to) {
            return 0;// no element
        } else if (from == to) {
            return left * nums[from] * right; // one element
        }

        int maxCoins = 0;
        for (int i = from; i <= to; i++) {
            int leftMax = dfs(nums, from, i - 1, left, nums[i]);
            int rightMax = dfs(nums, i + 1, to, nums[i], right);
            int coin = left * nums[i] * right;
            maxCoins = Math.max(maxCoins, leftMax + coin + rightMax);
        }

        return maxCoins;
    }

    public static void main(String[] args) {
        int m1 = maxCoins(new int[]{1, 5});
        int m2 = maxCoins(new int[]{3, 1, 5, 8});
        int m3 = maxCoins(new int[]{4});
    }
}
