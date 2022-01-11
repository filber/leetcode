package array_matrix;

// https://leetcode.com/problems/max-consecutive-ones-ii/
public class _487_MaxConsecutiveOnesII {

    // Given a binary array, find the maximum number of consecutive 1s in this array
    // if you can flip at most one 0.
    public static int findMaxConsecutiveOnes(int[] nums) {
        return longestOnes(nums,1);
    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int max = 0;
        int winState = 0;
        while (r < nums.length) {
            if (nums[r]==1) {
                r++;
            } else {
                if (winState<k) {
                    r++;
                    winState++;
                } else {
                    if (nums[l]==0) {
                        winState--;
                    }
                    l++;
                }
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public static void main(String[] args) {
        int m1 = findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}); // 4
        int m8 = findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1, 1}); // 5
        int m9 = findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 0, 1, 1}); // 4
        int m2 = findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 0}); // 5
        int m3 = findMaxConsecutiveOnes(new int[]{1, 1, 1, 1}); // 4
        int m4 = findMaxConsecutiveOnes(new int[]{1}); // 1
        int m5 = findMaxConsecutiveOnes(new int[]{0}); // 1
        int m6 = findMaxConsecutiveOnes(new int[]{0,1}); // 2
        int m7 = findMaxConsecutiveOnes(new int[]{1,0}); // 2
    }
}
