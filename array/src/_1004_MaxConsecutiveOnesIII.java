public class _1004_MaxConsecutiveOnesIII {
//    Given a binary array nums and an integer k,
//    return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//    Constraints:
//    1 <= nums.length <= 105
//    nums[i] is either 0 or 1.
//    0 <= k <= nums.length

    public static int longestOnes(int[] A, int K) {
        int winLeft = 0, winRight = 0, winMax = 0;
        while (winRight < A.length) {
            if (A[winRight] == 1 || K > 0) {
                // moving right
                if (A[winRight++] == 0) {
                    K--;
                }
            } else {
                // moving left
                if (A[winLeft++] == 0) {
                    K++;
                }
            }
            winMax = Math.max(winMax, winRight - winLeft);
        }
        return winMax;
    }

    public static void main(String[] args) {
//        Input: nums = [1,1,1,0,0,_0,1,1,1,1,_0], k = 2
//        Output: 6
//        Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
//        Input: nums = [0,0,1,1,_0,_0,1,1,1,_0,1,1,0,0,0,1,1,1,1], k = 3
//        Output: 10
//        Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 2));
    }
}
