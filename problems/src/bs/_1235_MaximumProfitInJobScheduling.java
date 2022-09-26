package bs;

import java.util.Arrays;

public class _1235_MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int begin = jobs[i][0];
            int value = jobs[i][2];
            int j = search(jobs, i - 1, begin);
            if (j == -1) {
                dp[i] = Math.max(dp[i - 1], value);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[j] + value);
            }
        }

        return dp[n - 1];
    }

    private int search(int[][] jobs, int r, int begin) {
        int l = 0;
        while (l < r) {
            if (l + 1 == r) {
                if (jobs[r][1] <= begin) {
                    return r;
                } else if (jobs[l][1] <= begin) {
                    return l;
                } else {
                    return -1;
                }
            }
            int mid = (l + r) / 2;
            int end = jobs[mid][1];
            if (end <= begin) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        if (jobs[l][1] <= begin) {
            return l;
        } else {
            return -1;
        }
    }
}
