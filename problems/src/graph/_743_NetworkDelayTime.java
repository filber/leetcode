package graph;

//https://leetcode.com/problems/network-delay-time/

import java.util.*;

public class _743_NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Construct Graph
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int weight = time[2];
            List<int[]> edges = graph[source];
            edges.add(new int[]{target, weight});
        }

        // 2. Breadth-First Search
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k, 0});
        while (!queue.isEmpty()) {
            // PQ always poll the shortest Edge
            int[] node = queue.poll();
            int source = node[0];
            int time = node[1];
            if (time > dp[source]) {
                continue; // no need to traverse edges of source
            }
            dp[source] = time;
            for (int[] edge : graph[source]) {
                int target = edge[0];
                int weight = edge[1];
                int nextTime = time + weight;
                if (dp[target] > nextTime) {
                    queue.add(new int[]{target, nextTime});
                    dp[target] = nextTime;
                }
            }
        }

        // 3. Traverse dp for max time
        int maxTime = Integer.MIN_VALUE;
        for (int time : dp) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            } else if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }
}
