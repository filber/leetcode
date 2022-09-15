package graph;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

public class _947_MostStonesRemovedWithSameRowOrColumn {


    int[] ids;
    int[] sz;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        ids = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sz[i] = 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x1 = stones[i][0];
            int y1 = stones[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = stones[j][0];
                int y2 = stones[j][1];
                if (x1 == x2 || y1 == y2) {
                    int id1 = find(i);
                    int id2 = find(j);
                    if (id1 != id2) {
                        union(id1, id2);
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    private void union(int pId, int qId) {
        int pSz = sz[pId];
        int qSz = sz[qId];
        if (pSz > qSz) {
            ids[qId] = pId;
            sz[pId] = pSz + qSz;
        } else {
            ids[pId] = qId;
            sz[qId] = pSz + qSz;
        }
    }

    private int find(int i) {
        while (ids[i] != i) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
}
