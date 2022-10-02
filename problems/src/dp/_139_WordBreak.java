package dp;

//https://leetcode.com/problems/word-break/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
            set.add(word);
        }

        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i; i - j + 1 <= maxLen && j > 0; j--) {
                String subStr = new String(chars, j - 1, i - j + 1);
                if (dp[j - 1] && set.contains(subStr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
