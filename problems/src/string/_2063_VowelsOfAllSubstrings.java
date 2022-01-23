package string;

// https://leetcode.com/problems/vowels-of-all-substrings/
public class _2063_VowelsOfAllSubstrings {

    public static long countVowels(String word) {
        int n = word.length();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                // combinations including ch
                // left #chars * right #chars
                sum += ((long) (n - i)) * (i + 1);
            }
        }
        return sum;
    }

    public static long countVowelsDP(String word) {
        int n = word.length();
        int[] dp = new int[n];
        char firstCh = word.charAt(0);
        if (firstCh == 'a' || firstCh == 'e' || firstCh == 'i' || firstCh == 'o' || firstCh == 'u') {
            dp[0] = 1;
        }

        long sum = dp[0];
        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                dp[i] = dp[i - 1] + i + 1;
            } else {
                dp[i] = dp[i - 1];
            }
            sum += dp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        // "a","ab","b", "ab", "ba", "a", "aba" = 0 + 1 + 1 + 1 + 1 + 2 = 6.
        long s1 = countVowels("aba");
        // "a", "ab", "abc", "b", "bc", "c" = 1 + 1 + 1 + 0 + 0 + 0 = 3.
        long s2 = countVowels("abc");
        // 0
        long s3 = countVowels("ltcd");
        // 1
        long s4 = countVowels("a");
        // 0
        long s5 = countVowels("b");
        // 2
        long s6 = countVowels("ab");
        // 2
        long s7 = countVowels("ba");
    }
}
