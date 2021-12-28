public class _303_RangeSumQuery {

//  Constraints:
//      0 <= nums.length <= 10^4
//      -10^5 <= nums[i] <= 10^5
//      0 <= i <= j < nums.length
//  At most 10^4 calls will be made to sumRange.

//  public static class NumArray {
//    /**
//     * Your NumArray object will be instantiated and called as such:
//     * NumArray obj = new NumArray(nums);
//     * int param_1 = obj.sumRange(i,j);
//     */
//
//    int[][] sum = null;
//
//    public NumArray(int[] nums) {
//      if (nums.length == 0) {
//        return;
//      }
//
//      sum = new int[nums.length][nums.length];
//
//      for (int i = 0; i < nums.length; i++) {
//        for (int j = i; j < nums.length; j++) {
//          if (i == j) {
//            sum[i][j] = nums[i];
//          } else {
//            sum[i][j] = nums[j] + sum[i][j - 1];
//          }
//        }
//      }
//    }
//
//    public int sumRange(int i, int j) {
//      if (sum == null) {
//        return 0;
//      }
//      return sum[i][j];
//    }
//  }

  public static class NumArray {

    int[] sum = null;

    public NumArray(int[] nums) {
      if (nums.length == 0) {
        return;
      }

      sum = new int[nums.length];

      for (int i = 0; i < nums.length; i++) {
        if (i == 0) {
          sum[0] = nums[0];
        } else {
          sum[i] = nums[i] + sum[i - 1];
        }
      }
    }

    public int sumRange(int i, int j) {
      if (sum == null) {
        return 0;
      }
      int preSum;
      if (i == 0) {
        preSum = 0;
      } else {
        preSum = sum[i - 1];
      }

      return sum[j] - preSum;
    }
  }

  public static void main(String[] args) {
//    Input
//    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//    Output
//    [null, 1, -1, -3]
    NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
    numArray.sumRange(0,2);
    numArray.sumRange(2,5);
    numArray.sumRange(0,5);
  }
}
