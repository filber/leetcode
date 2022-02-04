package array_matrix;

import java.util.Map;

// https://leetcode.com/problems/max-consecutive-ones/
public class _485_MaxConsecutiveOnes {

//    Given a binary array nums, return the maximum number of consecutive 1's in the array.
//    Constraints:
//    1 <= nums.length <= 10^5
//    nums[i] is either 0 or 1.
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        // dp[i] : maximum consecutive ones ending with i
        int dp = nums[0];
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i]==1) {
                dp += 1;
            } else {
                dp = 0;
            }
            maxLen = Math.max(maxLen,dp);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int m1 = findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}); // 3
        int m2 = findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}); // 2
    }
}
