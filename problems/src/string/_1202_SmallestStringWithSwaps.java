package string;

import java.util.*;

//https://leetcode.com/problems/smallest-string-with-swaps/
public class _1202_SmallestStringWithSwaps {

    int[] id;
    int[] sz;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        char[] chars = s.toCharArray();
        int n = chars.length;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int g = root(i);
            PriorityQueue<Character> pq = map.computeIfAbsent(g, k -> new PriorityQueue<>());
            pq.add(chars[i]);
        }

        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(root(i)).poll();
        }
        return new String(ans);
    }

    int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q) {
        int pId = root(p);
        int qId = root(q);
        if (pId == qId) {
            return;
        }
        int pSz = sz[pId];
        int qSz = sz[qId];
        if (pSz > qSz) {
            id[qId] = pId;
            sz[pId] += qSz;
        } else {
            id[pId] = qId;
            sz[qId] += pSz;
        }
    }
}
