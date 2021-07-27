public class _746_MinCostClimbingStairs {

  public static int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length+1];
    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
    }

    return dp[cost.length];
  }

  public static void main(String[] args) {
//    Input: cost = [10, 15, 20]
//    Output: 15
    minCostClimbingStairs(new int[] {10, 15, 20});

//    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//    Output: 6
    minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
  }
}
