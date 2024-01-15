package string;

//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram

public class _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        for(char sChar : sChars) {
            sFreq[sChar-'a']++;
        }
        for(char tChar : tChars) {
            tFreq[tChar-'a']++;
        }
        int result = 0;
        for(int i=0;i<26;i++){
            if(sFreq[i]<tFreq[i]) {
                result += (tFreq[i] - sFreq[i]);
            }
        }
        return result;
    }
}
