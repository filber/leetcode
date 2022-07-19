package tree;

//https://leetcode.com/problems/search-suggestions-system/

import java.util.*;

public class _1268_SearchSuggestionsSystem {

    class Trie {
        Trie[] children = new Trie[26];
        boolean end = false;
    }

    private void add(String word) {
        Trie cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Trie();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.end = true;
    }

    private List<String> search(String word) {
        Trie cur = root;
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            cur = cur.children[ch - 'a'];
            sb.append(ch);
            if (cur == null) {
                break;
            }
        }
        if (cur == null) {
            return List.of();
        }
        List<String> list = new ArrayList<>();
        dfs(list, sb, cur);
        return list;
    }

    private void dfs(List<String> list, StringBuilder sb, Trie node) {
        if (list.size() == 3) {
            return;
        } else if (node == null) {
            return;
        }

        if (node.end) {
            list.add(sb.toString());
        }

        for (int i = 0; i < node.children.length && list.size() < 3; i++) {
            if (node.children[i] != null) {
                sb.append((char) ('a' + i));
                dfs(list, sb, node.children[i]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    Trie root = new Trie();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products) {
            add(product);
        }
        List<List<String>> ans = new ArrayList<>();
        int len = searchWord.length();
        for (int i = 1; i <= len; i++) {
            String s = searchWord.substring(0, i);
            List<String> list = search(s);
            ans.add(list);
        }
        return ans;
    }
}
