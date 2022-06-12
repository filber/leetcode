package string;

//https://leetcode.com/problems/valid-anagram/

public class _242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] sCnt = new int[26];
        int[] tCnt = new int[26];
        for (char ch : s.toCharArray()) {
            sCnt[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCnt[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCnt[i] != tCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
