package string;

// https://leetcode.com/problemset/all/?search=1400&page=1
public class _1400_ConstructKPalindromeStrings {

    public static boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        if (k > 26) {
            return true;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCnt++;
            }
        }

        return oddCnt <= k;
    }

    public static void main(String[] args) {
        boolean example1 = canConstruct("annabelle", 2);
        boolean example2 = canConstruct("leetcode", 3);
        boolean example3 = canConstruct("true", 4);
        boolean example4 = canConstruct("yzyzyzyzyzyzyzy", 2);
        boolean example5 = canConstruct("cr", 7);

    }
}
