package bs;

//https://leetcode.com/problems/two-best-non-overlapping-events/

import java.util.Arrays;

public class _2054_TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            int[] event = events[i];
            int begin = event[0];
            int value = event[2];
            dp[i] = Math.max(dp[i - 1], value);
            int j = search(events, i - 1, begin);
            if (j == -1) {
                ans = Math.max(ans, value);
            } else {
                ans = Math.max(ans, dp[j] + value);
            }
        }

        return ans;
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
            int mid = (l + r) / 2;
            int end = events[mid][1];
            if (end >= begin) {
                r = mid - 1;
            } else {
                // end < begin
                l = mid;
            }
        }

        if (events[l][1] < begin) {
            return l;
        } else {
            return -1;
        }
    }
}
