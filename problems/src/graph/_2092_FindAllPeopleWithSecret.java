package graph;

import java.util.*;

//https://leetcode.com/problems/find-all-people-with-secret/

public class _2092_FindAllPeopleWithSecret {
    int[] size;
    int[] idx;

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        size = new int[n];
        idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
            size[i] = 1;
        }
        idx[firstPerson] = 0;
        size[0] = 2;

        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);

        for (int i = 0; i < meetings.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = i; j < meetings.length && meetings[i][2] == meetings[j][2]; j++) {
                int p = meetings[j][0];
                int q = meetings[j][1];
                temp.add(p);
                temp.add(q);
                union(p, q);
                i = j;
            }
            int root = find(0);
            for (Integer p : temp) {
                if (find(p) == root) {
                    secret.add(p);
                } else {
                    // person is not included in the secret group, revert the union operation
                    idx[p] = p;
                }
            }
        }
        return new ArrayList<Integer>(secret);
    }

    private int find(int i) {
        while (i != idx[i]) {
            idx[i] = idx[idx[i]];
            i = idx[i];
        }
        return i;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        int pSize = size[pRoot];
        int qSize = size[qRoot];
        if (pSize > qSize) {
            idx[qRoot] = pRoot;
            size[pRoot] += qSize;
        } else {
            idx[pRoot] = qRoot;
            size[qRoot] += pSize;
        }
    }
}
