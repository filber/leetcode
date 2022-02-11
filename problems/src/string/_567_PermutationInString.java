package string;

//https://leetcode.com/problems/permutation-in-string/

public class _567_PermutationInString {

    // Char Cnt & Sliding Window
    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }

        int[] s1Cnt = new int[26];
        char[] s1Chars = s1.toCharArray();
        for (int i = 0; i < m; i++) {
            s1Cnt[s1Chars[i] - 'a']++;
        }

        int[] winState = new int[26];
        // pay attention! just count the first m chars of s2
        char[] s2Chars = s2.toCharArray();

        for (int i = 0; i + m - 1 < n; i++) {
            // 1. Update window state
            if (i == 0) {
                for (int j = 0; j < m; j++) {
                    winState[s2Chars[j] - 'a']++;
                }
            } else {
                winState[s2Chars[i - 1] - 'a']--;
                winState[s2Chars[i + m - 1] - 'a']++;
            }

            // 2. Compare
            boolean eqFlag = true;
            for (int k = 0; k < 26; k++) {
                if (winState[k] != s1Cnt[k]) {
                    eqFlag = false;
                    break;
                }
            }
            if (eqFlag) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // true
        boolean b1 = checkInclusion("ab", "eidbaooo");
        // false
        boolean b2 = checkInclusion("ab", "eidboaoo");
        // false
        boolean b3 = checkInclusion("abz", "eidbaooo");
        // true
        boolean b4 = checkInclusion("a", "aaaa");
        // false
        boolean b5 = checkInclusion("b", "aaaa");
    }
}
