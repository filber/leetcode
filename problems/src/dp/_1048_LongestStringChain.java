package dp;

//https://leetcode.com/problems/longest-string-chain/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1048_LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int maxLen = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int n = word.length();
            int maxSubstr = 0;
            for (int i = 0; i < n; i++) {
                String substr = word.substring(0, i) + word.substring(i + 1);
                int len = map.getOrDefault(substr, 0);
                maxSubstr = Math.max(maxSubstr, len + 1);
            }
            map.put(word, maxSubstr);
            maxLen = Math.max(maxLen, maxSubstr);
        }

        return maxLen;
    }

    public int longestStrChainDP(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int[] dp = new int[n + 1];
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            int len = 0;
            for (int j = i - 1; j >= 1 && words[j - 1].length() >= words[i - 1].length() - 1; j--) {
                if (len < dp[j] && isPredecessor(words[j - 1], words[i - 1])) {
                    len = Math.max(len, dp[j]);
                }
            }
            dp[i] = len + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    private boolean isPredecessor(String L, String R) {
        if (L.length() == R.length()) {
            return false;
        }
        char[] lChars = L.toCharArray();
        char[] rChars = R.toCharArray();
        int l = 0, r = 0;
        boolean notEqualFound = false;
        while (l < lChars.length && r < rChars.length) {
            if (lChars[l] == rChars[r]) {
                l++;
                r++;
            } else if (!notEqualFound) {
                r++;
                notEqualFound = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
