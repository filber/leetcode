package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int wordLen = 0;
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            wordLen = Math.max(wordLen, word.length());
            set.add(word);
        }

        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int len = 1; len <= wordLen && i - len >= 0; len++) {
                int j = i - len;
                String word = new String(chars, j, len);
                if (set.contains(word) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
