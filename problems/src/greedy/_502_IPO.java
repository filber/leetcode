package greedy;

//https://leetcode.com/problems/ipo/

import java.util.PriorityQueue;

public class _502_IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> capitalQueue = new PriorityQueue<>(
                (a, b) -> capital[a] == capital[b] ? Integer.compare(profits[b], profits[a]) : Integer.compare(capital[a], capital[b])
        );
        PriorityQueue<Integer> profitQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(profits[b], profits[a])
        );

        int n = profits.length;
        for (int i = 0; i < n; i++) {
            capitalQueue.add(i);
        }

        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && capital[capitalQueue.peek()] <= w) {
                profitQueue.add(capitalQueue.poll());
            }
            if (!profitQueue.isEmpty()) {
                w += profits[profitQueue.poll()];
            } else {
                break;
            }
        }
        return w;
    }
}
