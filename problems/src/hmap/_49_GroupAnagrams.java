package hmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
public class _49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = convert(str);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }

    private String convert(String str) {
        int[] chCnt = new int[26];
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            chCnt[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (chCnt[i] != 0) {
                sb.append((char) ('a' + i));
                sb.append(chCnt[i]);
            }
        }
        return sb.toString();
    }
}
