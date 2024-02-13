package dp;

//https://leetcode.com/problems/predict-the-winner/
public class _486_PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) {
            dp[i][i] = nums[i];
        }
        for(int len=2;len<=n;len++) {
            for(int i=0,j=len-1;j<n;i++,j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1]>=0;
    }
}
