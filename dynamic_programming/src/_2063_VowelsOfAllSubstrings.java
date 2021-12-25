// TIPS:
// For substring, considering startIndex and endIndex.
// DP[i] to represent the all substrings starting with i or ending with i
// DP[i] = DP[i-1] + i !!!!
public class _2063_VowelsOfAllSubstrings {
    private static final int[] vowels = new int[26];
    static {
        vowels['a' - 'a'] = 1;
        vowels['e' - 'a'] = 1;
        vowels['i' - 'a'] = 1;
        vowels['o' - 'a'] = 1;
        vowels['u' - 'a'] = 1;
    }

    public static long countVowels(String word) {
        int len = word.length();
        long[] dp = new long[len];
        dp[0] = vowels[word.charAt(0) - 'a'];
        long sum = dp[0];
        for (int i = 1; i < len; i++) {
            if (vowels[word.charAt(i) - 'a']==1) {
                dp[i] = dp[i - 1] + i + 1;
            } else {
                dp[i] = dp[i - 1];
            }
            sum += dp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long s4 = countVowels("a");
        long s5 = countVowels("b");
        long s6 = countVowels("ab");
        long s7 = countVowels("ba");

//        Input: word = "aba"
//      "a","ab","b", "ab", "ba", "a", "aba" = 0 + 1 + 1 + 1 + 1 + 2 = 6.
        long s1 = countVowels("aba");

//        Input: word = "abc"
//      "a", "ab", "abc", "b", "bc", "c" = 1 + 1 + 1 + 0 + 0 + 0 = 3.
        long s2 = countVowels("abc");

//        Input: word = "ltcd"
//        Output: 0
        long s3 = countVowels("ltcd");
    }
}
