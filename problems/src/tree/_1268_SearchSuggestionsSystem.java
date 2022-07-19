package tree;

//https://leetcode.com/problems/search-suggestions-system/

import java.util.*;

public class _1268_SearchSuggestionsSystem {

    class Trie {
        Trie[] children = new Trie[26];
        List<Integer> indices = new ArrayList<>();
    }

    private void add(String word,int i) {
        Trie cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Trie();
            }
            cur = cur.children[ch - 'a'];
            cur.indices.add(i);
        }
    }

    private List<String> search(String word) {
        Trie cur = root;
        for (char ch : word.toCharArray()) {
            cur = cur.children[ch - 'a'];
            if (cur == null) {
                break;
            }
        }
        if (cur == null) {
            return List.of();
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3 && i < cur.indices.size(); i++) {
            list.add(products[cur.indices.get(i)]);
        }
        return list;
    }

    Trie root = new Trie();
    String[] products;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.products = products;
        Arrays.sort(products);
        for (int i = 0; i < products.length; i++) {
            add(products[i], i);
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
