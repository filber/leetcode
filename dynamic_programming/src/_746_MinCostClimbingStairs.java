public class _746_MinCostClimbingStairs {

//  Note:
//  cost will have a length in the range [2, 1000].
//  Every cost[i] will be an integer in the range [0, 999].

  public static int minCostClimbingStairs(int[] cost) {
    int twoStepBefore = cost[0];
    int oneStepBefore = cost[1];
    int curr = 0;
    for(int i = 2;i< cost.length;i++){
      curr = Math.min(twoStepBefore,oneStepBefore) + cost[i];
      twoStepBefore = oneStepBefore;
      oneStepBefore = curr;
    }
    return Math.min(oneStepBefore,twoStepBefore);
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
