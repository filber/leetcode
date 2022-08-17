package string;

//https://leetcode.com/problems/unique-morse-code-words/

import java.util.HashSet;
import java.util.Set;

public class _804_UniqueMorseCodeWords {

    private static final String[] ENCODE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String encode = convert(word);
            set.add(encode);
        }
        return set.size();
    }

    private String convert(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            sb.append(ENCODE[ch - 'a']);
        }
        return sb.toString();
    }
}
