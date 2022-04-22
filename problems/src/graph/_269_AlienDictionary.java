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


        List<char[]> edges = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            String p = words[i];
            String q = words[i + 1];
            for (int j = 0; j < Math.min(p.length(), q.length()); j++) {
                char pCh = p.charAt(j);
                char qCh = q.charAt(j);
                if (pCh != qCh) {
                    // add edge : pCh -> qCh
                    edges.add(new char[]{pCh, qCh});
                    break;
                }
            }
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        for (char[] edge : edges) {
            char from = edge[0], to = edge[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new HashSet<>());
            }
            if (!graph.containsKey(to)) {
                graph.put(to, new HashSet<>());
            }

            graph.get(from).add(to);
            inDegree[to - 'a']++;
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            char key = (char) ('a' + i);
            if (inDegree[i] == 0 && graph.containsKey(key)) {
                queue.add(key);
            }
        }

        // cycle found
        if (queue.isEmpty()) {
            return "";
        }

        Set<Character> visited = new HashSet<>();
        // need one more capacity to store 0-outDegree node
        char[] order = new char[graph.keySet().size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            order[idx++] = ch;
            visited.add(ch);
            Set<Character> toSet = graph.getOrDefault(ch, new HashSet<>());
            for (char to : toSet) {
                if (visited.contains(to)) {
                    return ""; // found cycle
                }
                queue.add(to);
            }
        }

        return new String(order);
    }
}
