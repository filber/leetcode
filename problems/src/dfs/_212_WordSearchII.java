package dfs;

//https://leetcode.com/problems/word-search-ii/

import java.util.ArrayList;
import java.util.List;

public class _212_WordSearchII {

    public class Trie {
        Trie[] children = new Trie[26];
        char ch;
        public Trie(char ch) {
            this.ch = ch;
        }
    }

    Trie root = new Trie('\0');

    private boolean search(String word) {
        char[] chars = word.toCharArray();
        Trie cur = root;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (cur.children[ch - 'a'] == null) {
                return false;
            }
            cur = cur.children[ch - 'a'];
        }
        return true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 1. Traverse words for min/max length
        int max = Integer.MIN_VALUE;
        for (String word : words) {
            max = Math.max(max, word.length());
        }

        // 2. Construct Trie from board
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(board, visited, root, m, n, max, 0, i, j);
            }
        }

        // 3. Traverse words for valid ones by searching in Trie
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (search(word)) {
                list.add(word);
            }
        }
        return list;
    }

    private void backtracking(char[][] board, boolean[][] visited, Trie node, int m, int n, int max, int len, int i, int j) {
        if (len == max) {
            return;
        } else if (i < 0 || i == m || j < 0 || j == n) {
            return;
        } else if (visited[i][j]) {
            return;
        }
        char ch = board[i][j];
        if (node.children[ch - 'a'] == null) {
            node.children[ch - 'a'] = new Trie(ch);
        }
        node = node.children[ch - 'a'];
        visited[i][j] = true;
        backtracking(board, visited, node, m, n, max, len + 1, i - 1, j);
        backtracking(board, visited, node, m, n, max, len + 1, i + 1, j);
        backtracking(board, visited, node, m, n, max, len + 1, i, j - 1);
        backtracking(board, visited, node, m, n, max, len + 1, i, j + 1);
        visited[i][j] = false;
    }
}
