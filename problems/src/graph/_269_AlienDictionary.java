package graph;

//https://leetcode.com/problems/alien-dictionary/

import java.util.*;

public class _269_AlienDictionary {

//    There is a new alien language which uses the latin alphabet.
//    However, the order among letters are unknown to you.
//    You receive a list of non-empty words from the dictionary,
//    where words are sorted lexicographically by the rules of this new language.
//    Derive the order of letters in this language.

//    Note:
//    You may assume all letters are in lowercase.
//    You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
//    If the order is invalid, return an empty string.
//    There may be multiple valid order of letters, return any one of them is fine.

    public String alienOrder(String[] words) {
        if (words == null || words.length < 2) {
            return "";
        }
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> outDegree = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            char[] lChars = words[i].toCharArray();
            char[] rChars = words[i + 1].toCharArray();
            for (int j = 0; j < Math.min(lChars.length, rChars.length); j++) {
                if (lChars[j] == rChars[j]) {
                    continue;
                }
                char lCh = lChars[j];
                char rCh = rChars[j];
                Set<Character> set = graph.computeIfAbsent(rCh, k -> new HashSet<>());
                if (!set.contains(lCh)) {
                    outDegree.put(lCh, outDegree.getOrDefault(lCh, 0) + 1);
                    set.add(lCh);
                }
                graph.computeIfAbsent(lCh, k -> new HashSet<>());
                break;
            }
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (Character node : graph.keySet()) {
            if (!outDegree.containsKey(node)) {
                queue.add(node);
            }
        }
        if (queue.isEmpty()) {
            return "";
        }
        
        char[] seq = new char[graph.size()];
        boolean[] used = new boolean[26];
        int idx = seq.length - 1;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            seq[idx--] = ch;
            used[ch - 'a'] = true;
            for (char adj : graph.get(ch)) {
                if (used[adj - 'a']) {
                    return ""; // cycle detected
                }
                int out = outDegree.get(adj);
                outDegree.put(adj, out - 1);
                if (out == 1) {
                    queue.add(adj);
                }
            }
        }

        return new String(seq);
    }
}
