package dp;

//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

public class _1335_MinimumDifficultyOfAJobSchedule {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        } else if (n == d) {
            int sum = 0;
            for (int job : jobDifficulty) {
                sum += job;
            }
            return sum;
        }

        // dp[i][j]: minimum difficulty of scheduling first i jobs for j days.
        int[][] dp = new int[n + 1][d + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 2000;
        }
        for (int j = 1; j <= d; j++) {
            // i==j, assign one job to every day, total difficult = sum{jobDifficult}
            dp[j][j] = dp[j - 1][j - 1] + jobDifficulty[j - 1];
            dp[0][j] = 2000;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i && j <= d; j++) {
                // assign first i-k jobs for j-1 days, assign last k jobs to the last day
                int minDifficulty = Integer.MAX_VALUE;
                int maxJob = Integer.MIN_VALUE;
                for (int k = 1; i - k >= j - 1; k++) {
                    maxJob = Math.max(maxJob, jobDifficulty[i - k]);
                    minDifficulty = Math.min(minDifficulty, dp[i - k][j - 1] + maxJob);
                }
                dp[i][j] = minDifficulty;
            }
        }

        return dp[n][d];
    }
}
