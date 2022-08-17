package tree;

//https://leetcode.com/problems/short-encoding-of-words/

import java.util.Arrays;

public class _820_ShortEncodingOfWords {

    class Trie {
        Trie[] children = new Trie[26];

        public void insert(String word) {
            Trie cur = this;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                char ch = chars[i];
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
            }
        }

        public boolean search(String word) {
            Trie cur = this;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                char ch = chars[i];
                if (cur.children[ch - 'a'] == null) {
                    return false;
                }
                cur = cur.children[ch - 'a'];
            }
            return true;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int length = 0;
        for (String word : words) {
            if (!root.search(word)) {
                length += word.length() + 1;
                root.insert(word);
            }
        }
        return length;
    }
}
