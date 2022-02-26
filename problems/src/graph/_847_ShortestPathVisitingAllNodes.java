package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class _847_ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) {
            return 0;
        }
        // [111111...] means all nodes haven been visited
        int target = (1 << n) - 1;
        // access states: seen[1][1100]=true
        // under the condition of 2ed and 3rd (1100) nodes have been accessed, 1st node has been accessed
        boolean[][] seen = new boolean[n][target];

        int[] masks = new int[n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            masks[i] = 1 << i;
            int[] pair = {i, masks[i]};
            queue.add(pair);
        }

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int node = pair[0];
                int mask = pair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | masks[neighbor];
                    if (nextMask == target) {
                        return level;
                    }

                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true;
                        queue.add(new int[]{neighbor, nextMask});
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
