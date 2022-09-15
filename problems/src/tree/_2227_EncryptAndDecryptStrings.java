package tree;

//https://leetcode.com/problems/encrypt-and-decrypt-strings/

import java.util.ArrayList;
import java.util.List;

public class _2227_EncryptAndDecryptStrings {

    public static class Encrypter {

        class Trie {
            char ch;
            List<Character> list = null;
            Trie[] children = new Trie[26];
        }

        Trie VTrie = new Trie();

        String[] keyToValue = new String[26];
        List<Character>[][] DTable = new List[26][26];

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (int i = 0; i < keys.length; i++) {
                char key = keys[i];
                keyToValue[key - 'a'] = values[i];
            }

            initVTrie(dictionary);
            initDTable(keys, values);
        }

        private void initVTrie(String[] dictionary) {
            for (String word : dictionary) {
                char[] chars = word.toCharArray();
                Trie node = VTrie;
                for (char ch : chars) {
                    if (node.children[ch - 'a'] == null) {
                        node.children[ch - 'a'] = new Trie();
                        node.children[ch - 'a'].ch = ch;
                    }
                    node = node.children[ch - 'a'];
                }
                node.list = new ArrayList<>();
            }
        }

        private void initDTable(char[] keys, String[] values) {
            for (int i = 0; i < values.length; i++) {
                char key = keys[i];
                String value = values[i];
                char ch0 = value.charAt(0);
                char ch1 = value.charAt(1);
                List<Character> list = DTable[ch0 - 'a'][ch1 - 'a'];
                if (list == null) {
                    DTable[ch0 - 'a'][ch1 - 'a'] = new ArrayList<>();
                    list = DTable[ch0 - 'a'][ch1 - 'a'];
                }
                list.add(key);
            }
        }


        public String encrypt(String word) {
            char[] chars = word.toCharArray();
            char[] rst = new char[chars.length * 2];
            int idx = 0;
            for (char ch : chars) {
                String val = keyToValue[ch - 'a'];
                rst[idx++] = val.charAt(0);
                rst[idx++] = val.charAt(1);
            }
            return new String(rst);
        }

        private void backtracking(Trie node, char[] chars, int i) {
            if (i == chars.length) {
                if (node.list != null) {
                    count++;
                }
                return;
            }
            char ch0 = chars[i];
            char ch1 = chars[i + 1];
            List<Character> list = DTable[ch0 - 'a'][ch1 - 'a'];
            if (list == null) {
                return;
            }
            for (char ch : list) {
                if (node.children[ch - 'a'] == null) {
                    continue;
                }
                backtracking(node.children[ch - 'a'], chars, i + 2);
            }
        }

        int count = 0;
        public int decrypt(String word) {
            char[] chars = word.toCharArray();
            count = 0;
            List<String> ans = new ArrayList<>();
            backtracking(VTrie, chars, 0);
            return count;
        }
    }
}
