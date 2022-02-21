package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/word-pattern-ii/
public class _291_WordPatternII {

    char[] pChars;
    char[] sChars;
    Map<Character, String> pToS = new HashMap<>();
    Map<String, Character> sToP = new HashMap<>();

    public boolean wordPattern(String pattern, String s) {
        pChars = pattern.toCharArray();
        sChars = s.toCharArray();
        if (pChars.length > sChars.length) {
            return false;
        }

        boolean res = dfs(0, 0);
        return res;
    }

    private boolean dfs(int i, int j) {
        // 0. Guard condition
        if (i == pChars.length && j == sChars.length) {
            return true;
        } else if (i == pChars.length || j >= sChars.length) {
            return false;
        }
        char pChar = pChars[i];
        if (pToS.containsKey(pChar)) {
            String str = pToS.get(pChar);
            if (j + str.length() > sChars.length
                    || !str.equals(new String(sChars, j, str.length()))) {
                return false;
            }
            if (!sToP.containsKey(str) || !sToP.get(str).equals(pChar)) {
                return false;
            }

            return dfs(i + 1, j + str.length());
        } else {
            for (int k = j; k < sChars.length; k++) {
                int len = k - j + 1;
                String ss = new String(sChars, j, len);
                // set states
                pToS.put(pChar, ss);
                sToP.put(ss, pChar);
                if (dfs(i + 1, j + len)) {
                    return true;
                } else {
                    // reverse states
                    pToS.remove(pChar);
                    sToP.remove(ss);
                }
            }
            return false;
        }
    }
}
