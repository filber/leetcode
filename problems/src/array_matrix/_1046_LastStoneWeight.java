package array_matrix;

//https://leetcode.com/problems/last-stone-weight/

import java.util.PriorityQueue;

public class _1046_LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int largest = queue.poll();
            int secondLargest = queue.poll();
            if (largest != secondLargest) {
                queue.add(largest - secondLargest);
            }
        }

        if (queue.isEmpty()) {
            return 0;
        } else {
            return queue.poll();
        }
    }
}
