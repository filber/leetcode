package greedy;

//https://www.geeksforgeeks.org/find-m-th-smallest-value-in-k-sorted-arrays/

import java.util.PriorityQueue;

public class _EX_KthSmallestNumberInMSortedLists {

    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length; i++) {
            int[] elem = new int[]{arr[i][0], i, 0};
            pq.add(elem);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            int[] peek = pq.poll();
            ans = peek[0];
            peek[2]++;
            if (peek[2] != arr[peek[1]].length) {
                peek[0] = arr[peek[1]][peek[2]];
                pq.add(peek);
            }
        }
        return ans;
    }
}
