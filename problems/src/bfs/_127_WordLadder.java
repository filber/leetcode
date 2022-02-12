package bfs;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class _127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        int trans = 2;
        while (!begin.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String s : begin) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[i] = k; // replace
                        String cand = new String(chars);
                        if (end.contains(cand)) {
                            return trans;
                        } else if (wordSet.contains(cand)) {
                            next.add(cand);
                            // remove candidate from wordSet, so won't try it in the future.
                            wordSet.remove(cand);
                        }
                    }
                    // reverse
                    chars[i] = tmp;
                }
            }
            // Didn't find in current level, increase transit
            trans++;

            if (next.size() <= end.size()) {
                // search forward
                begin = next;
            } else {
                // search backward
                // Reverse the order, from end to next
                begin = end;
                end = next;
            }
        }

        return 0;
    }

    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        int w = beginWord.length();
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        // 0. Guard condition
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int trans = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String next = queue.poll();
                if (next.equals(endWord)) {
                    return trans;
                } else {
                    char[] sb = next.toCharArray();
                    // modify one position each time
                    for (int j = 0; j < sb.length; j++) {
                        char cur = sb[j];
                        for (char k = 'a'; k <= 'z'; k++) {
                            // Just consider valid letter at position j
                            sb[j] = k;
                            String candidate = new String(sb);
                            if (wordSet.contains(candidate)) {
                                queue.add(candidate);
                                // Remove candidate so next time won't try it
                                wordSet.remove(candidate);
                            }
                        }
                        // reverse
                        sb[j] = cur;
                    }
                }
            }
            trans++;
        }
        return 0;
    }

}
