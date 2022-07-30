package string;

//https://leetcode.com/problems/word-subsets/

import java.util.ArrayList;
import java.util.List;

public class _916_WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[26];
        for (String word : words2) {
            int[] tmp = new int[26];
            for (char ch : word.toCharArray()) {
                tmp[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], tmp[i]);
            }
        }

        List<String> list = new ArrayList<>();
        for (String word : words1) {
            int[] tmp = new int[26];
            for (char ch : word.toCharArray()) {
                tmp[ch - 'a']++;
            }
            boolean universal = true;
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < count[i]) {
                    universal = false;
                    break;
                }
            }
            if (universal) {
                list.add(word);
            }
        }
        return list;
    }
}
