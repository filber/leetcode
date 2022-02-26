package graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class _847_ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;
        // [111111...] means all nodes haven been visited
        int target = (1 << n) - 1;
        // access states: seen[1][1100]=true
        // under the condition of 2ed and 3rd (1100) nodes have been accessed, 1st node has been accessed
        boolean[][] seen = new boolean[n][target];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int source = 1 << i;
            q.add(new int[]{i, source});
            seen[i][source] = true;
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] currentPair = q.remove();
                int node = currentPair[0];
                int mask = currentPair[1]; // status of node
                for (int nei : graph[node]) {
                    int nextMask = mask | (1 << nei);
                    if (nextMask == target) {
                        // all nodes have been accessed
                        return level + 1;
                    }

                    if (!seen[nei][nextMask]) {
                        seen[nei][nextMask] = true;
                        q.add(new int[]{nei, nextMask});
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
