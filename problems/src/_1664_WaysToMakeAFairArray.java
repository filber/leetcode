public class _1664_WaysToMakeAFairArray {
  public static int waysToMakeFair(int[] nums) {
    int evenSum = 0;
    int oddSum = 0;

    int[] evenBefore = new int[nums.length];
    int[] oddBefore = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        evenSum += nums[i];
        evenBefore[i] = evenSum - nums[i];
        oddBefore[i] = oddSum;
      } else {
        oddSum += nums[i];
        oddBefore[i] = oddSum - nums[i];
        evenBefore[i] = evenSum;
      }
    }

    int ways = 0;
    for (int i = 0; i < nums.length; i++) {
      int first = 0;
      int second = 0;
      if (i % 2 == 0) {
        first = evenBefore[i] + (oddSum - oddBefore[i]);
        second = (evenSum - evenBefore[i]) + oddBefore[i] - nums[i];
      } else {
        first = oddBefore[i] + (evenSum - evenBefore[i]);
        second = (oddSum - oddBefore[i]) + evenBefore[i] - nums[i];
      }
      if (first == second) {
        ways++;
      }
    }
    return ways;
  }

  public static void main(String[] args) {
    //    Input: nums = [2,1,6,4]
    //    Output: 1
    waysToMakeFair(new int[] {2, 1, 6, 4});

    //    Input: nums = [1,1,1]
    //    Output: 3
    waysToMakeFair(new int[] {1, 1, 1});

    //    Input: nums = [1,2,3]
    //    Output: 0
    waysToMakeFair(new int[] {1, 2, 3});
  }

}
