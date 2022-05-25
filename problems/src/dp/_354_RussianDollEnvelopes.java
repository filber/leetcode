package dp;

//https://leetcode.com/problems/russian-doll-envelopes/

import java.util.Arrays;

public class _354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;
        for (int[] env : envelopes) {
            int l = 0, r = len;
            int h = env[1];
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (dp[mid] >= h) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            dp[l] = h;
            if (l == len) {
                len++;
            }
        }
        return len;
    }
}
