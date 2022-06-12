package dp;

//https://leetcode.com/problems/word-break/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String str = s.substring(j, i);
                if (wordDict.contains(str) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
