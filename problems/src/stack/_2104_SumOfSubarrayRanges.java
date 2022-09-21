package stack;

//https://leetcode.com/problems/sum-of-subarray-ranges/


public class _2104_SumOfSubarrayRanges {

    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        int[] smallerStack = new int[n];
        int smallerTop = -1;
        int[] smallerLeft = new int[n];
        int[] smallerRight = new int[n];
        int[] greaterStack = new int[n];
        int greaterTop = -1;
        int[] greaterLeft = new int[n];
        int[] greaterRight = new int[n];
        for (int i = 0; i < n; i++) {
            smallerLeft[i] = -1;
            smallerRight[i] = n;
            while (smallerTop >= 0 && arr[smallerStack[smallerTop]] >= arr[i]) {
                int peek = smallerStack[smallerTop--];
                smallerRight[peek] = i;
            }
            if (smallerTop >= 0) {
                smallerLeft[i] = smallerStack[smallerTop];
            }
            smallerStack[++smallerTop] = i;

            greaterLeft[i] = -1;
            greaterRight[i] = n;
            while (greaterTop >= 0 && arr[greaterStack[greaterTop]] <= arr[i]) {
                int peek = greaterStack[greaterTop--];
                greaterRight[peek] = i;
            }
            if (greaterTop >= 0) {
                greaterLeft[i] = greaterStack[greaterTop];
            }
            greaterStack[++greaterTop] = i;
        }

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            long smallerL = i - smallerLeft[i];
            long smallerR = smallerRight[i] - i;
            long greaterL = i - greaterLeft[i];
            long greaterR = greaterRight[i] - i;
            sum += (greaterL * greaterR - smallerL * smallerR) * arr[i];
        }

        return sum;
    }

    public long subArrayRangesDP(int[] nums) {
        long sum = 0L;
        int n = nums.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < nums.length; i++) {
                int j = i + len - 1;
                dp[i][j][0] = Math.min(dp[i][j - 1][0], nums[j]);
                dp[i][j][1] = Math.max(dp[i][j - 1][1], nums[j]);
                sum += dp[i][j][1] - dp[i][j][0];
            }
        }

        return sum;
    }
}
