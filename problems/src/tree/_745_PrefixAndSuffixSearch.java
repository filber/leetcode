package tree;

//https://leetcode.com/problems/prefix-and-suffix-search/

import java.util.*;

public class _745_PrefixAndSuffixSearch {

    static public class WordFilter {


        class Trie {
            Trie[] children;
            List<Integer> indices;

            public Trie() {
                children = new Trie[26];
                indices = new ArrayList<>();
            }
        }

        Trie root = new Trie();

        void add(String word, int i) {
            char[] chars = word.toCharArray();
            Trie cur = root;
            for (int j = 0; j < chars.length; j++) {
                if (cur.children[chars[j] - 'a'] == null) {
                    cur.children[chars[j] - 'a'] = new Trie();
                }
                cur = cur.children[chars[j] - 'a'];
                cur.indices.add(i);
            }

        }

        List<Integer> search(Trie node, String word) {
            List<Integer> list = new ArrayList<>();
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                node = node.children[chars[i] - 'a'];
                if (node == null) {
                    break;
                }
            }
            if (node == null) {
                return list;
            }
            return node.indices;
        }

        String[] words;
        public WordFilter(String[] words) {
            this.words = words;
            for (int i = 0; i < words.length; i++) {
                add(words[i], i);
            }
        }

        public int f(String prefix, String suffix) {
            List<Integer> forword = search(root, prefix);
            for (int i = forword.size() - 1; i >= 0; i--) {
                int idx = forword.get(i);
                if (words[idx].endsWith(suffix)) {
                    return idx;
                }
            }
            return -1;
        }
    }
}
