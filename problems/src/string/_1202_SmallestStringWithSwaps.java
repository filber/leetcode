package string;

import java.util.*;

//https://leetcode.com/problems/smallest-string-with-swaps/
public class _1202_SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] id = new int[n];
        int[] sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (List<Integer> edge : pairs) {
            int from = edge.get(0);
            int to = edge.get(1);
            union(id, sz, from, to);
        }

        Map<Integer, int[]> map = new HashMap<>();
        int[] gIDs = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            int gid = root(id, i);
            gIDs[i] = gid;
            int[] cnt = map.computeIfAbsent(gid, k -> new int[27]);
            cnt[ch - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            int gid = gIDs[i];
            int[] cnt = map.get(gid);
            int cur = cnt[26];
            for (int k = cur; k < 26; k++) {
                if (cnt[k] > 0) {
                    cnt[26] = k;
                    chars[i] = (char) (k + 'a');
                    cnt[k]--;
                    break;
                }
            }
        }

        return new String(chars);
    }

    int root(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private void union(int[] id, int[] sz, int p, int q) {
        int pId = root(id, p);
        int qId = root(id, q);
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
