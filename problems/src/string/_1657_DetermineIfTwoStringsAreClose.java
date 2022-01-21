package string;

// https://leetcode.com/problems/determine-if-two-strings-are-close/

import java.util.Arrays;

public class _1657_DetermineIfTwoStringsAreClose {

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((cnt1[i] != 0 && cnt2[i] == 0) || (cnt1[i] == 0 && cnt2[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // true
        boolean b1 = closeStrings("abc", "bca");

        // false
        boolean b2 = closeStrings("a", "aa");

        // true
        boolean b3 = closeStrings("cabbba", "abbccc");

        // false
        boolean b4 = closeStrings("cabbba", "aabbss");
    }
}
