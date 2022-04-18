package greedy;

//https://leetcode.com/problems/minimum-cost-to-connect-sticks/

import java.util.PriorityQueue;

public class _1167_MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            cost += sum;
            pq.add(sum);
        }

        return cost;
    }
}
