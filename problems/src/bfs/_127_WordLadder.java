package bfs;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class _127_WordLadder {

    // Two Pointers
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int jumps = 2;
        while (!beginSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String candidate = new String(chars);
                        if (endSet.contains(candidate)) {
                            // contains must locate at here!
                            return jumps;
                        } else if (wordSet.contains(candidate)) {
                            nextSet.add(candidate);
                            wordSet.remove(candidate);
                        }
                    }
                    chars[i] = tmp;
                }
            }

            jumps++;
            if (nextSet.size() > endSet.size()) {
                beginSet = endSet;
                endSet = nextSet;
            } else {
                beginSet = nextSet;
            }
        }

        return 0;
    }

    // BFS
    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int jumps = 1;
        int curLevelCnt = 1;
        int nextLevelCnt = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        wordSet.remove(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curLevelCnt--;
            if (word.equals(endWord)) {
                return jumps;
            }
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char tmpChar = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String candidate = new String(chars);
                    if (wordSet.contains(candidate)) {
                        queue.add(candidate);
                        wordSet.remove(candidate);
                        nextLevelCnt++;
                    }
                }
                chars[i] = tmpChar;
            }

            if (curLevelCnt == 0) {
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
                jumps++;
            }
        }

        // can't reach the endWord
        return 0;
    }

}
