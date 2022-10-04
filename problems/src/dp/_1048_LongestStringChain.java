package dp;

//https://leetcode.com/problems/longest-string-chain/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1048_LongestStringChain {

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int i = 1;
        while (i < words.length && words[i].length() == words[i - 1].length()) {
            dp[i++] = 1;
        }
        int maxLen = 1;
        for (; i < n; i++) {
            if (words[i - 1].length() + 1 < words[i].length()) {
                dp[i] = 1;
            } else {
                dp[i] = 1;
                for (int j = 0; j < words[i].length(); j++) {
                    String subStr = words[i].substring(0, j) + words[i].substring(j + 1);
                    if (map.containsKey(subStr)) {
                        dp[i] = Math.max(dp[i], dp[map.get(subStr)] + 1);
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
