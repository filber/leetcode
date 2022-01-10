package string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
//[Sliding Window]
public class _340_LongestSubstringWithAtMostKDistinctCharacters {

//    Given a string, find the length of the longest substring T that contains at most k distinct characters.
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int winLeft = 0, winRight = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (winRight < s.length()) {
            if (map.size() < k || map.containsKey(s.charAt(winRight))) {
                char ch = s.charAt(winRight);
                Integer cnt = map.get(ch);
                if (cnt == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, cnt + 1);
                }
                winRight++;
            } else {
                char ch = s.charAt(winLeft);
                Integer cnt = map.get(ch);
                if (cnt.equals(1)) {
                    map.remove(ch);
                } else {
                    map.put(ch, cnt - 1);
                }
                winLeft++;
            }
            maxLen = Math.max(maxLen, winRight - winLeft);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // 3 - ece
        int l1 = lengthOfLongestSubstringKDistinct("eceba", 2);
        // 2 - aa
        int l2 = lengthOfLongestSubstringKDistinct("aa", 1);
        // 5 - ecebe
        int l3 = lengthOfLongestSubstringKDistinct("ecebe", 3);
        //3 - eee
        int l4 = lengthOfLongestSubstringKDistinct("beeea", 1);
        //3 - abc
        int l5 = lengthOfLongestSubstringKDistinct("abc", 3);
    }
}
