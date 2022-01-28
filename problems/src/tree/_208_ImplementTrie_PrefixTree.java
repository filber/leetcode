package tree;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class _208_ImplementTrie_PrefixTree {
    static class Trie {

        private Trie[] children;
        private boolean end = false;

        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Trie cur = this;
            for (char ch : chars) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            Trie cur = this;
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.children[ch - 'a'];
                }
            }
            return cur.end;
        }

        public boolean startsWith(String prefix) {
            Trie cur = this;
            for (char ch : prefix.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    return false;
                } else {
                    cur = cur.children[ch - 'a'];
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean b1 = trie.search("apple");   // True
        boolean b2 = trie.search("app");     // False
        boolean b3 = trie.startsWith("app"); // True
        trie.insert("app");
        boolean b4 = trie.search("app");     // True
    }
}
