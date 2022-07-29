package string;

import java.util.ArrayList;
import java.util.List;

public class _890_FindAndReplacePattern {

    char[] pChars;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        pChars = pattern.toCharArray();

        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean isMatch(String word) {
        char[] wpMap = new char[26];
        char[] pwMap = new char[26];
        char[] wChars = word.toCharArray();
        for (int i = 0; i < pChars.length; i++) {
            char ch = wChars[i];
            int wIdx = ch - 'a';
            char pCh = pChars[i];
            int pIdx = pCh - 'a';
            if (wpMap[wIdx] == 0) {
                wpMap[wIdx] = pCh;
            } else if (wpMap[wIdx] != pCh) {
                return false;
            }

            if (pwMap[pIdx] == 0) {
                pwMap[pIdx] = ch;
            } else if (pwMap[pIdx] != ch) {
                return false;
            }
        }
        return true;
    }
}
