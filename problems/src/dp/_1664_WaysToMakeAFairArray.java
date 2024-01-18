package dp;

// https://leetcode.com/problems/ways-to-make-a-fair-array/

public class _1664_WaysToMakeAFairArray {

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] evenSum = new int[n];
        int[] oddSum = new int[n];
        evenSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int val = nums[i];
            if (i % 2 == 0) {
                evenSum[i] = evenSum[i - 1] + val;
                oddSum[i] = oddSum[i - 1];
            } else {
                evenSum[i] = evenSum[i - 1];
                oddSum[i] = oddSum[i - 1] + val;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int leftEvenSum = evenSum[i];
            int leftOddSum = oddSum[i];
            if (i % 2 == 0) {
                leftEvenSum -= val;
            } else {
                leftOddSum -= val;
            }
            int rightEvenSum = oddSum[n - 1] - oddSum[i];
            int rightOddSum = evenSum[n - 1] - evenSum[i];
            if (leftEvenSum + rightEvenSum == leftOddSum + rightOddSum) {
                result++;
            }
        }
        return result;
    }
}
