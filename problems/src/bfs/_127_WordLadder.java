package bfs;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class _127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet(wordList);
        Set<String> begin = new HashSet();
        Set<String> end = new HashSet();

        if (!words.contains(endWord)) return 0;

        begin.add(beginWord);
        end.add(endWord);

        int step = 2;

        while (!begin.isEmpty()) {
            Set<String> next = new HashSet();
            for (String curr : begin) {
                char[] ch = curr.toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    char cr = ch[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        ch[j] = k;
                        String temp = String.valueOf(ch);
                        if (end.contains(temp)) return step;
                        if (words.contains(temp)) {
                            words.remove(temp);
                            next.add(temp);
                        }
                        ch[j] = cr;
                    }
                }
            }
            step++;

            if (next.size() > end.size()) {
                begin = end;
                end = next;
            } else {
                begin = next;
            }
        }

        return 0;
    }

    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        int w = beginWord.length();
        // valid char at each position
        int[][] charSet = new int[w][26];
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
            for (int i = 0; i < w; i++) {
                charSet[i][word.charAt(i) - 'a']++;
            }
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
                    for (int j = 0; j < next.length(); j++) {
                        for (int k = 0; k < 26; k++) {
                            // Just consider valid letter at position j
                            if (charSet[j][k] > 0) {
                                sb[j] = (char) ('a' + k);
                                String candidate = new String(sb);
                                if (wordSet.contains(candidate)) {
                                    queue.add(candidate);
                                    // Remove candidate so next time won't try it
                                    wordSet.remove(candidate);
                                }
                            }
                        }
                        // reverse
                        sb[j] = next.charAt(j);
                    }
                }
            }
            trans++;
        }
        return 0;
    }

}
