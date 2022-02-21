package string;

// https://leetcode.com/problems/word-pattern/submissions/

import java.util.HashMap;
import java.util.Map;

public class _290_WordPattern {

//    Constraints:
//        1 <= pattern.length <= 300
//        pattern contains only lower-case English letters.
//        1 <= s.length <= 3000
//        s contains only lowercase English letters and spaces ' '.
//        s does not contain any leading or trailing spaces.
//        All the words in s are separated by a single space.

    //  BIJECTION between a letter in pattern and a non-empty word in s.
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] pChars = pattern.toCharArray();
        int n = pChars.length;
        if (n != words.length) {
            return false;
        }

        int[] pToS = new int[128];
        Map<Integer, Character> sToP = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char pChar = pChars[i];
            String word = words[i];
            int wordHash = word.hashCode();
            if (pToS[pChar] == 0) {
                pToS[pChar] = word.hashCode();
            } else if (pToS[pChar] != wordHash) {
                return false;
            }

            Character ch = sToP.get(wordHash);
            if (ch == null) {
                sToP.put(wordHash, pChar);
            } else if (!ch.equals(pChar)) {
                return false;
            }
        }

        return true;
    }
}
