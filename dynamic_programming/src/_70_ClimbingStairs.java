public class _70_ClimbingStairs {

  // how many distinct WAYS can you climb to the top?
  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0]= 1;
    dp[1]= 1;
    for (int i = 2; i <= n ; i++) {
      // add up different ways!
      // don't need max or min when calculate WAYS
      dp[i] = dp[i - 2] + dp[i - 1];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    _70_ClimbingStairs instance = new _70_ClimbingStairs();
    int result = instance.climbStairs(4);
    assert result == 3;
  }

}
