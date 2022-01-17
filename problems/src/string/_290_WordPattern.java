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

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }

        Map<Character, Integer> mapP2S = new HashMap<>();
        Map<Integer, Character> mapS2P = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            // Project from pattern to str
            Character ch = pattern.charAt(i);
            Integer code = mapP2S.get(ch);
            if (code == null) {
                mapP2S.put(ch, arr[i].hashCode());
            } else {
                if (!code.equals(arr[i].hashCode())) {
                    return false;
                }
            }

            code = arr[i].hashCode();
            ch = mapS2P.get(code);
            if (ch == null) {
                mapS2P.put(code,pattern.charAt(i));
            } else {
                if (!ch.equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean b1 = wordPattern("abba", "dog cat cat dog"); // true
        boolean b2 = wordPattern("abba", "dog cat cat fish"); // false
        boolean b3 = wordPattern("aaaa", "dog cat cat dog"); // false
        boolean b4 = wordPattern("aaaa", "dog dog dog dog"); // true
        boolean b5 = wordPattern("aaaa", "dog dog dog dog dog"); // false
        boolean b6 = wordPattern("abba", "dog dog dog dog"); // false

    }
}
