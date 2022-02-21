package dp;

// https://leetcode.com/problems/vowels-of-all-substrings/
public class _2063_VowelsOfAllSubstrings {

    // Return the sum of the number of vowels ('a', 'e', 'i', 'o', and 'u')
    // in every substring of word.
    public long countVowelsMath(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;
        long count = 0L;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                int leftCnt = i + 1;
                int rightCnt = n - i;
                count += ((long) leftCnt) * rightCnt;
            }
        }

        return count;
    }

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
        long[] dp = new long[n];
        dp[0] = vowels[chars[0] - 'a'] == 1 ? 1 : 0;
        long count = dp[0];
        for (int i = 1; i < n; i++) {
            char ch = chars[i];
            if (vowels[ch - 'a'] == 1) {
                dp[i] = dp[i - 1] + i + 1;
            } else {
                dp[i] = dp[i - 1];
            }
            count += dp[i];
        }

        return count;
    }
}
