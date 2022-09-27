package bs;

//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/

import java.util.Arrays;

public class _1751_MaximumNumberOfEventsThatCanBeAttendedII {

    public int maxValue(int[][] events, int K) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[][] dp = new int[n][K];
        // Init DP for k=0 (at least one event)
        dp[0][0] = events[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], events[i][2]);
        }
        for (int j = 1; j < K; j++) {
            dp[0][j] = events[0][2];
        }

        int[] eventsBefore = new int[n];
        eventsBefore[0] = -1;
        for (int i = 1; i < n; i++) {
            int begin = events[i][0];
            int j = search(events, i - 1, begin);
            eventsBefore[i] = j;
        }

        for (int k = 1; k < K; k++) {
            for (int i = 1; i < n; i++) {
                int value = events[i][2];
                dp[i][k] = dp[i - 1][k];
                int j = eventsBefore[i];
                if (j == -1) {
                    dp[i][k] = Math.max(dp[i][k], value);
                } else {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + value);
                }
            }
        }

        return dp[n - 1][K - 1];
    }

    private int search(int[][] events, int r, int begin) {
        int l = 0;
        while (l < r) {
            if (l + 1 == r) {
                if (events[r][1] < begin) {
                    return r;
                } else if (events[l][1] < begin) {
                    return l;
                } else {
                    return -1;
                }
            }
            int mid = l + (r - l) / 2;
            int end = events[mid][1];
            if (end < begin) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        if (events[l][1] >= begin) {
            return -1;
        } else {
            return l;
        }
    }
}
