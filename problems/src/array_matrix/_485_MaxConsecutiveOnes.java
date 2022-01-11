package array_matrix;

// https://leetcode.com/problems/max-consecutive-ones/
public class _485_MaxConsecutiveOnes {

//    Given a binary array nums, return the maximum number of consecutive 1's in the array.
//    Constraints:
//    1 <= nums.length <= 105
//    nums[i] is either 0 or 1.

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cnt = 0;
        for (int num : nums) {
            if (num==1) {
                cnt++;
                max = cnt > max ? cnt : max;
            } else {
                cnt = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int m1 = findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}); // 3
        int m2 = findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}); // 2
    }
}
