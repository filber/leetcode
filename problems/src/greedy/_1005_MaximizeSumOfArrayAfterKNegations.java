package greedy;

// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
import java.util.Arrays;

public class _1005_MaximizeSumOfArrayAfterKNegations {

    //  Constraint:
    //      1 <= A.length <= 10000
    //      1 <= K <= 10000
    //      -100 <= A[i] <= 100
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (k != 0) {
                if (num < 0) {
                    sum -= num;
                    k--;
                } else if (num == 0) {
                    k = 0;
                } else if (num > 0) {
                    if (k%2==0) {
                      sum += num;
                    } else if (i==0){
                      // k is odd
                      sum += -num;
                    } else {
                      // nums[i-1] negative, nums[i] positive, k is odd
                      sum += nums[i-1]; // subtract nums[i-1] from sum
                      sum += Math.abs(nums[i-1] + nums[i]);
                    }
                    k = 0;
                }
            } else {
                sum += num;
            }
        }

        if (k>0) {
          // last num is negative
          sum += nums[nums.length - 1]; // subtract nums[i-1] from sum
          if (k%2==0) {
            sum -= nums[nums.length - 1];
          } else {
            sum += nums[nums.length - 1];
          }
        }

        return sum;
    }

    public static void main(String[] args) {
        int s1 = largestSumAfterKNegations(new int[]{4, 2, 3}, 1); // 5
        int s2 = largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3); // 6
        int s3 = largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2); // 13
        int s4 = largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6); // 22
        int s5 = largestSumAfterKNegations(new int[]{-4,-2,-3}, 4); // 5
    }
}
