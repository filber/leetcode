package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _787_CheapestFlightsWithinKStops {

    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{src, 0, 0});

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            Map<Integer, Integer> pMap = map.computeIfAbsent(from, key -> new HashMap<>());
            pMap.put(to, price);
        }

        Map<Integer, Integer> stopMap = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int city = node[0];
            int stops = node[1];
            int price = node[2];
            if (city == dst) {
                return price;
            }
            if (stops > k) {
                continue;
            }
            if (!map.containsKey(city)) {
                continue;
            }
            if (stopMap.containsKey(city) && stops >= stopMap.get(city)) {
                continue;
            }
            stopMap.put(city, stops);
            for (Map.Entry<Integer, Integer> entry : map.get(city).entrySet()) {
                pq.add(new int[]{entry.getKey(), stops + 1, price + entry.getValue()});
            }
        }

        return -1;
    }


    Map<Integer, Integer>[][] dp;

    public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int k) {
        dp = new Map[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashMap<>();
            }
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            Map<Integer, Integer> pMap = map.computeIfAbsent(from, key -> new HashMap<>());
            pMap.put(to, price);
        }

        dfs(src, dst, k);
        int price = dp[src][dst].getOrDefault(k, Integer.MAX_VALUE);
        if (price == Integer.MAX_VALUE) {
            return -1;
        } else {
            return price;
        }
    }

    private int dfs(int src, int dst, int k) {
        if (src == dst) {
            return 0;
        } else if (k < 0) {
            return Integer.MAX_VALUE;
        }
        Integer minPrice = dp[src][dst].get(k);
        if (minPrice != null) {
            return minPrice;
        }
        minPrice = Integer.MAX_VALUE;
        Map<Integer, Integer> adjMap = map.getOrDefault(src, new HashMap<>());
        for (Map.Entry<Integer, Integer> entry : adjMap.entrySet()) {
            int adj = entry.getKey();
            int price = entry.getValue();
            int next = dfs(adj, dst, k - 1);
            if (next != Integer.MAX_VALUE) {
                minPrice = Math.min(minPrice, price + next);
            }
        }
        dp[src][dst].put(k, minPrice);

        return minPrice;
    }
}
