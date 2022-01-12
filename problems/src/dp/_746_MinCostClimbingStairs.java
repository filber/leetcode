package dp;

// https://leetcode.com/problems/min-cost-climbing-stairs/

public class _746_MinCostClimbingStairs {

  public static int minCostClimbingStairs(int[] cost) {
    int pre2 = 0;
    int pre1 = cost[0];
    for (int i = 1; i < cost.length; i++) {
      int temp = pre1;
      pre1 = Math.min(pre1, pre2) + cost[i];
      pre2 = temp;
    }
    return Math.min(pre1, pre2);
  }

  public static void main(String[] args) {
//    Input: cost = [10, 15, 20]
//    Output: 15
      int m1 = minCostClimbingStairs(new int[] {10, 15, 20});

//    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//    Output: 6
      int m2 = minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
  }
}
