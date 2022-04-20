package greedy;

import java.util.*;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

public class _373_FindKPairsWithSmallestSums {

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    int[] A;
    int[] B;

    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {
        this.A = A;
        this.B = B;
        int[] first = new int[]{0, 0, A[0] + B[0]};
        pq.add(first);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] triple = pq.poll();
            int l = triple[0];
            int r = triple[1];
            ans.add(Arrays.asList(A[l], B[r]));

            if (l == r) {
                add(l + 1, r + 1);
                add(l + 1, r);
                add(l, r + 1);
            } else if (l < r) {
                add(l, r + 1);
            } else {
                add(l + 1, r);
            }
        }
        return ans;
    }

    private void add(int l, int r) {
        if (l >= A.length || r >= B.length) {
            return;
        }
        pq.add(new int[]{l, r, A[l] + B[r]});
    }
}
