package graph;

//https://leetcode.com/problems/accounts-merge/

import java.util.*;

public class _721_AccountsMerge {

    int[] ids;
    int[] sz;

    private int find(int id) {
        while (ids[id] != id) {
            ids[id] = ids[ids[id]];
            id = ids[id];
        }
        return id;
    }

    private void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        int pSz = sz[pId];
        int qSz = sz[qId];
        if (pSz > qSz) {
            ids[qId] = pId;
            sz[pId] += sz[qId];
        } else {
            ids[pId] = qId;
            sz[qId] += sz[pId];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        ids = new int[n];
        sz = new int[n];

        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sz[i] = 1;

        }

        String[] names = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> emails = accounts.get(i);
            names[i] = accounts.get(i).get(0);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                Integer id = map.get(email);
                if (id == null) {
                    map.put(email, i);
                } else {
                    union(i, id);
                }
            }
        }

        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            int id = find(val);
            list.get(id).add(entry.getKey());
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.get(i).isEmpty()) {
                continue;
            }
            List<String> emails = list.get(i);
            Collections.sort(emails);
            emails.add(0, names[i]);
            ans.add(emails);
        }
        return ans;
    }
}
