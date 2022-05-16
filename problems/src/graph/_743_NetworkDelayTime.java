package graph;

//https://leetcode.com/problems/network-delay-time/

import java.util.*;

public class _743_NetworkDelayTime {

    // Prime
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Construct Graph
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            int source = edge[0];
            int target = edge[1];
            int weight = edge[2];
            graph[source].add(new int[]{target, weight});
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int t = node[1];
            if (t >= dp[i]) {
                continue;
            }
            dp[i] = t;
            for (int[] entry : graph[i]) {
                int target = entry[0];
                int w = entry[1];
                int nextT = t + w;
                if (nextT < dp[target]) {
                    queue.add(new int[]{target, nextT});
                }
            }
        }

        int maxDelay = Integer.MIN_VALUE;
        for (int delay : dp) {
            if (delay == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, delay);
        }
        return maxDelay;
    }
}
