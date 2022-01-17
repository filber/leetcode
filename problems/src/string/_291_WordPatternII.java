package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/word-pattern-ii/
public class _291_WordPatternII {

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        boolean dfsRes = dfs(pattern, s, map, 0, 0);
        if (!dfsRes) {
            return false;
        }

        Set<String> set = new HashSet<>();
        for (String str : map.values()) {
            set.add(str);
        }
        // need to be Bijection
        return map.size() == set.size();
    }

    private static boolean dfs(String pattern, String s, Map<Character, String> map,
                               int pStart, int strStart) {
        // 0. Guard conditions
        if (pStart == pattern.length() && strStart == s.length()) {
            return true;
        } else if (pStart == pattern.length() || strStart == s.length()) {
            return false;
        }

        char key = pattern.charAt(pStart);
        if (map.containsKey(key)) {
            // 1. already mapped
            String value = map.get(key);
            if (s.length() - strStart < value.length()) {
                // 1.1. no enough str
                return false;
            } else if (value.equals(s.substring(strStart, strStart + value.length()))) {
                // 1.2. matched, DFS for remaining
                boolean remain = dfs(pattern, s, map, pStart + 1, strStart + value.length());
                if (remain) {
                    return true;
                } else {
                    return false;
                }
            } else {
                // 1.3. not matched, reverse state
                return false;
            }
        } else {
            // 2. not already mapped, try substring from shortest to longest
            int strEnd = strStart;
            while (strEnd < s.length()) {
                // set state & try
                map.put(key, s.substring(strStart, strEnd + 1));
                if (!dfs(pattern, s, map, pStart + 1, strEnd + 1)) {
                    // DFS for remaining failed, reverse state
                    map.remove(key);
                    strEnd++;
                } else {
                    return true;
                }
            }
            // failed for all length
            return false;
        }
    }

    public static void main(String[] args) {

        // true
        // {'a'<->'red', 'b'<->'blue'}
        boolean b1 = wordPattern("abab", "redblueredblue");

        // true
        // {'a'<->'asd'}
        boolean b2 = wordPattern("aaaa", "asdasdasdasd");

        // false
        // {'a'->'xyz', 'a'->'abc', 'b'->'xzy','b'->'abc'}
        boolean b3 = wordPattern("aabb", "xyzabcxzyabc");

        // true
        // {'a'->'b'}
        boolean b4 = wordPattern("a", "b");

        // true
        // {'a'->'dog ', 'b'->'cat '}
        boolean b5 = wordPattern("abba", "dog cat cat dog ");
        // false
        boolean b6 = wordPattern("abba", "dog cat cat fish ");
        // false
        boolean b7 = wordPattern("aaaa", "dog cat cat dog ");
        // true
        // {'a'->'dog '}
        boolean b8 = wordPattern("aaaa", "dog dog dog dog ");
        // false
        boolean b9 = wordPattern("aaaa", "dog dog dog dog dog ");
        // false
        // {'a'->'dog ', 'b'->'dog '} duplicate!
        boolean b10 = wordPattern("abba", "dog dog dog dog ");
    }
}
