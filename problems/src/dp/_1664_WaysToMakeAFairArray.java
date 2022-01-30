package dp;

// https://leetcode.com/problems/ways-to-make-a-fair-array/

public class _1664_WaysToMakeAFairArray {

    //  Constraints:
//          1 <= nums.length <= 10^5
//          1 <= nums[i] <= 10^4
    public static int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] evenPS = new int[n];
        int[] oddPS = new int[n];
        evenPS[0] = nums[0];
        oddPS[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                evenPS[i] = evenPS[i - 1] + nums[i];
                oddPS[i] = oddPS[i - 1];
            } else {
                evenPS[i] = evenPS[i - 1];
                oddPS[i] = oddPS[i - 1] + nums[i];
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int leftEPS = i > 0 ? evenPS[i - 1] : 0;
            int leftOPS = i > 0 ? oddPS[i - 1] : 0;
            int rightEPS = oddPS[n - 1] - oddPS[i];
            int rightOPS = evenPS[n - 1] - evenPS[i];
            int evenSum = leftEPS + rightEPS;
            int oddSum = leftOPS + rightOPS;
            if (evenSum == oddSum) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int w1 = waysToMakeFair(new int[]{2, 1, 6, 4}); // 1
        int w2 = waysToMakeFair(new int[]{1, 1, 1}); // 3
        int w3 = waysToMakeFair(new int[]{1, 2, 3}); // 0
        int w4 = waysToMakeFair(new int[]{1}); // 1
    }
}
