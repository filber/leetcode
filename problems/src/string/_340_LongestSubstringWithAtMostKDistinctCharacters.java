package string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
//[Sliding Window]
public class _340_LongestSubstringWithAtMostKDistinctCharacters {

    //    Given a string, find the length of the longest substring T that contains at most k distinct characters.
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int maxLen = 0;
        while (r < n) {
            char rChar = chars[r];
            if (map.size() < k || map.containsKey(rChar)) {
                map.put(rChar, map.getOrDefault(rChar, 0) + 1);
                r++;
            } else {
                char lChar = chars[l];
                Integer lCnt = map.get(lChar);
                if (lCnt.equals(1)) {
                    map.remove(lChar);
                } else {
                    map.put(lChar, lCnt - 1);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}
