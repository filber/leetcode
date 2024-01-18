package dp;

//https://leetcode.com/problems/substring-with-largest-variance/

import java.util.HashSet;
import java.util.Set;

public class _2272_SubstringWithLargestVariance {

    public int largestVariance(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch: chars) {
            set.add(ch);
        }
        int n = chars.length;
        int result = 0;
        // dp[i][0]: max sum of subarray ending with chars[i] if it doesn't contain -1
        // dp[i][1]: max sum of subarray ending with chars[i] if it contains -1
        int[][] dp = new int[n][2];

        for (char bigCh: set) {
            for (char smallCh: set) {
                if (bigCh == smallCh) {
                    continue;
                }

                if (chars[0] == bigCh) {
                    dp[0][0] = 1;
                    dp[0][1] = Integer.MIN_VALUE / 2;
                } else if (chars[0] == smallCh) {
                    dp[0][0] = 0; // Empty
                    dp[0][1] = -1;
                }

                for (int i = 1; i < n; i++) {
                    char ch = chars[i];
                    if (ch == bigCh) {
                        dp[i][0] = dp[i - 1][0] + 1;
                        dp[i][1] = dp[i - 1][1] + 1;
                    } else if (ch == smallCh) {
                        dp[i][0] = 0;
                        dp[i][1] = Math.max(dp[i - 1][0] - 1, dp[i - 1][1] - 1);
                    } else {
                        dp[i][0] = dp[i - 1][0];
                        dp[i][1] = dp[i - 1][1];
                    }
                    result = Math.max(result, dp[i][1]);
                }
            }
        }

        return result;
    }
}
