package dp;

//https://leetcode.com/problems/russian-doll-envelopes/

import java.util.Arrays;

public class _354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] env = envelopes[i];
            int h = env[1];
            int l = 0, r = maxLen;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (dp[mid] >= h) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            dp[l] = h;
            if (l == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }
}
