package string;

//https://leetcode.com/problems/find-the-difference/

public class _389_FindTheDifference {

    public static char findTheDifference(String s, String t) {
        int[] sCnt = new int[26];
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            sCnt[sChars[i] - 'a']++;
        }

        int[] tCnt = new int[26];
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            tCnt[tChars[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (tCnt[i] > sCnt[i]) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        // e
        char c1 = findTheDifference("abcd","abcde");
        // y
        char c2 = findTheDifference("","y");
    }
}
