public class _485_MaxConsecutiveOnes {

//    Given a binary array nums, return the maximum number of consecutive 1's in the array.
//    Constraints:
//    1 <= nums.length <= 105
//    nums[i] is either 0 or 1.

    public static int findMaxConsecutiveOnes(int[] nums) {
        int acc = 0;
        int maxAcc = 0;
        for (int num : nums) {
            if (num == 1) {
                acc ++;
                maxAcc = acc > maxAcc ? acc : maxAcc;
            } else {
                acc = 0;
            }
        }
        return maxAcc;
    }

    public static void main(String[] args) {

//        Input: nums = [1,1,0,1,1,1]
//        Output: 3
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));

//        Input: nums = [1,0,1,1,0,1]
//        Output: 2
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));

    }
}
