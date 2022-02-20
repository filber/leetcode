package string;

// https://leetcode.com/problems/construct-k-palindrome-strings/

public class _1400_ConstructKPalindromeStrings {

    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) {
            return false;
        } else if (k > 26) {
            return true;
        }

        int[] cnt = new int[26];
        for (char ch :s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int oldCnt = 0;
        for (int i = 0; i < 26; i++) {
            oldCnt += cnt[i] % 2;
        }
        return oldCnt <= k;
    }
}
