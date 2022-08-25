package string;

//https://leetcode.com/problems/ransom-note/

public class _383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rChars = ransomNote.toCharArray();
        int[] rCnt = new int[26];
        char[] mChars = magazine.toCharArray();
        int[] mCnt = new int[26];
        if (rChars.length > mChars.length) {
            return false;
        }

        for (char ch : rChars) {
            rCnt[ch - 'a']++;
        }

        for (char ch : mChars) {
            mCnt[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (rCnt[i] > mCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
