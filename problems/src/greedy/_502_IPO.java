package greedy;

//https://leetcode.com/problems/ipo/

import java.util.PriorityQueue;

public class _502_IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // sort capital by ascending order
        PriorityQueue<Integer> pqCap = new PriorityQueue<>((a, b) -> Integer.compare(capital[a], capital[b]));
        // sort profit by descending order
        PriorityQueue<Integer> pqPro = new PriorityQueue<>((a, b) -> Integer.compare(profits[b], profits[a]));
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            pqCap.add(i);
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && capital[pqCap.peek()] <= w) {
                pqPro.add(pqCap.poll());
            }

            if (pqPro.isEmpty()) {
                break;
            }
            w += profits[pqPro.poll()];
        }
        return w;
    }
}
