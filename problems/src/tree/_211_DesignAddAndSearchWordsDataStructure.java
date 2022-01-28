package tree;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class _211_DesignAddAndSearchWordsDataStructure {
    public static class WordDictionary {

        public static class Trie {
            Trie[] children = new Trie[26];
            boolean end = false;
        }

        private Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            return dfs(word.toCharArray(),0, root);
        }

        private boolean dfs(char[] chars, int pos, Trie cur) {
            if (pos == chars.length) {
                return cur.end;
            }
            char ch = chars[pos];
            if (ch != '.') {
                if (cur.children[ch - 'a'] != null) {
                    return dfs(chars, pos + 1, cur.children[ch - 'a']);
                } else {
                    return false;
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    if (cur.children[i] != null && dfs(chars, pos + 1, cur.children[i])) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary w1 = new WordDictionary();
        w1.addWord("bad");
        w1.addWord("dad");
        w1.addWord("mad");
        boolean b1 = w1.search("pad"); // False
        boolean b2 = w1.search("bad"); // True
        boolean b3 = w1.search("badf"); // False
        boolean b4 = w1.search("b"); // False
        boolean b5 = w1.search(".ad"); // True
        boolean b6 = w1.search("b.."); // True
        boolean b7 = w1.search("b..."); // False
    }
}
