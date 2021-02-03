public class _1043_PartitionArrayForMaximumSum {
//  Constraints:
//      1 <= arr.length <= 500
//      0 <= arr[i] <= 109
//      1 <= k <= arr.length

  public static int maxSumAfterPartitioning(int[] arr, int k) {
    int[] dp = new int[arr.length];
    dp[0] = arr[0];
    for (int i = 1; i < dp.length; i++) {
      int sum = 0;
      int max = 0;
      for (int j = 1; j <= k && (i - j) >= -1; j++) {
        int previous = i - j >= 0 ? dp[i - j] : 0;
        max = Math.max(max, i - j>=-1?arr[i - j+1]:0);
        int current = j * max;
        sum = Math.max(sum, previous + current);
      }
      dp[i] = sum;
    }

    return dp[arr.length - 1];
  }

  public static void main(String[] args) {
//    Input: arr = [1,15,7,9,2,5,10], k = 3
//    Output: 84
//    Explanation: arr becomes [15,15,15,9,10,10,10]
    maxSumAfterPartitioning(new int[] {1, 15, 7, 9, 2, 5, 10}, 3);
//    Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
//    Output: 83
    maxSumAfterPartitioning(new int[] {1,4,1,5,7,3,6,1,9,9,3}, 4);
//    Input: arr = [1], k = 1
//    Output: 1
  }
}
