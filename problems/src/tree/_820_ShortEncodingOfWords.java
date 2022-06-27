package tree;

//https://leetcode.com/problems/short-encoding-of-words/

import java.util.Arrays;

public class _820_ShortEncodingOfWords {
    class Trie {

        private Trie[] children;

        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie trie = this;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                char ch = chars[i];
                if (trie.children[ch - 'a'] == null) {
                    trie.children[ch - 'a'] = new Trie();
                }
                trie = trie.children[ch - 'a'];
            }
        }

        public boolean search(String word) {
            Trie trie = this;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                char ch = chars[i];
                if (trie.children[ch - 'a'] == null) {
                    return false;
                }
                trie = trie.children[ch - 'a'];
            }
            return true;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
        Trie trie = new Trie();
        int len = 0;
        for (String word : words) {
            if (!trie.search(word)) {
                trie.insert(word);
                len += word.length() + 1;
            }
        }
        return len;
    }
}
