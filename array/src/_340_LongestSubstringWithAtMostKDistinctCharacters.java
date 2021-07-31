import java.util.HashMap;
import java.util.Map;

public class _340_LongestSubstringWithAtMostKDistinctCharacters {

//    Given a string, find the length of the longest substring T that contains at most k distinct characters.

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int winLeft = 0, winRight = 0, winMax = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (winRight < s.length()) {
            if (map.containsKey(s.charAt(winRight)) || map.size() < k) {
                // move right
                char ch = s.charAt(winRight++);
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            } else {
                // move left
                char ch = s.charAt(winLeft++);
                int count = map.get(ch);
                if (count > 1) {
                    map.put(ch, count - 1);
                } else {
                    map.remove(ch);
                }
            }
            winMax = Math.max(winMax, winRight - winLeft);
        }
        return winMax;
    }

    public static void main(String[] args) {
//        Input: s = "eceba", k = 2
//        Output: 3
//        Explanation: T is "ece" which its length is 3.
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));

//        Input: s = "aa", k = 1
//        Output: 2
//        Explanation: T is "aa" which its length is 2.
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));

        System.out.println(lengthOfLongestSubstringKDistinct("ecebe", 3));

        System.out.println(lengthOfLongestSubstringKDistinct("beeea", 1));

        System.out.println(lengthOfLongestSubstringKDistinct("abc", 3));

    }
}
