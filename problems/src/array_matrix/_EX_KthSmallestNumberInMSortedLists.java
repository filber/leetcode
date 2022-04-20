package array_matrix;

//https://www.geeksforgeeks.org/find-m-th-smallest-value-in-k-sorted-arrays/

import java.util.PriorityQueue;

public class _EX_KthSmallestNumberInMSortedLists {

    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i][0];
            // list id, cursor of list i, current head of list
            pq.add(new int[]{i, 0, val});
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            int[] triple = pq.poll();
            ans = triple[2];

            triple[1]++;
            if (triple[1] < arr[triple[0]].length) {
                triple[2] = arr[triple[0]][triple[1]];
                pq.add(triple);
            }
        }

        return ans;
    }
}
