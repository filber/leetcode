package string;

// https://leetcode.com/problems/determine-if-two-strings-are-close/

import java.util.Arrays;

public class _1657_DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String a, String b) {
        int n = a.length();
        if (b.length() != n) {
            return false;
        }
        int[] aCnt = new int[26];
        int[] bCnt = new int[26];
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = 0; i < n; i++) {
            aCnt[aChars[i] - 'a']++;
            bCnt[bChars[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((aCnt[i] != 0 && bCnt[i] == 0) || (aCnt[i] == 0 && bCnt[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(aCnt);
        Arrays.sort(bCnt);

        for (int i = 25; i >= 0; i--) {
            if (aCnt[i] != bCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
