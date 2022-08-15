package string;

import java.util.ArrayList;
import java.util.List;

public class _890_FindAndReplacePattern {

    char[] pChars;
    int n;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        pChars = pattern.toCharArray();
        n = pChars.length;

        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean isMatch(String word) {
        char[] wToP = new char[26];
        char[] pToW = new char[26];
        char[] wChars = word.toCharArray();
        for (int i = 0; i < n; i++) {
            char pCh = pChars[i];
            char wCh = wChars[i];
            if (pToW[pCh - 'a'] == 0) {
                pToW[pCh - 'a'] = wCh;
            } else if (pToW[pCh - 'a'] != wCh) {
                return false;
            }

            if (wToP[wCh - 'a'] == 0) {
                wToP[wCh - 'a'] = pCh;
            } else if (wToP[wCh - 'a'] != pCh) {
                return false;
            }
        }
        return true;
    }
}
