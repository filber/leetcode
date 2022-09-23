package graph;

//https://leetcode.com/problems/network-delay-time/

import java.util.*;

public class _743_NetworkDelayTime {

    // Dijkstra
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Construct Graph
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int delay = time[2];
            graph[source].add(new int[]{target, delay});
        }

        // 2. Init PQ & dist
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int target = node[0];
            int delay = node[1];
            if (delay >= dist[target]) {
                continue;
            }
            dist[target] = delay;
            for (int[] neighbor : graph[target]) {
                int nextTarget = neighbor[0];
                int nextDelay = delay + neighbor[1];
                if (nextDelay < dist[nextTarget]) {
                    pq.add(new int[]{nextTarget, nextDelay});
                }
            }
        }

        int maxDelay = Integer.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            int delay = dist[i];
            if (delay == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, delay);
        }
        return maxDelay;
    }
}
