public class _487_MaxConsecutiveOnesII {


    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = -1;
        int right = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                right++;
            } else {
                left = right;
                right = 0;
            }
            maxCount = Math.max(maxCount, left + right + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
//        Input: [1,0,1,1,0]
//        Output: 4
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));

//        Input: [1,1,1,1,0]
//        Output: 5
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 0}));

//        Input: [1,1,1,1]
//        Output: 4
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 1}));

//        Input: [1]
//        Output: 1
        System.out.println(findMaxConsecutiveOnes(new int[]{1}));

//        Input: [0]
//        Output: 1
        System.out.println(findMaxConsecutiveOnes(new int[]{0}));

//        Input: [0,1]
//        Output: 2
        System.out.println(findMaxConsecutiveOnes(new int[]{0,1}));

//        Input: [1,0]
//        Output: 2
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0}));
    }
}
