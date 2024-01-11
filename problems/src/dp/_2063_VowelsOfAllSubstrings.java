package dp;

// https://leetcode.com/problems/vowels-of-all-substrings/
public class _2063_VowelsOfAllSubstrings {
    // DP
    public long countVowels(String word) {
        int[] vowels = new int[26];
        vowels['a'-'a'] = 1;
        vowels['e'-'a'] = 1;
        vowels['i'-'a'] = 1;
        vowels['o'-'a'] = 1;
        vowels['u'-'a'] = 1;

        char[] chars = word.toCharArray();
        int n = chars.length;
        long[] dp = new long[n + 1];
        long count = 0;
        for (int i = 1; i <= n; i++) {
            char ch = chars[i - 1];
            if (vowels[ch - 'a'] == 1) {
                dp[i] = dp[i - 1] + i;
            } else {
                dp[i] = dp[i - 1];
            }
            count += dp[i];
        }

        return count;
    }
}
