package graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class _210_CourseScheduleII {

    public int[] findOrder(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int from = edge[1];
            int to = edge[0];
            degree[to]++;
            graph[from].add(to);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[n];
        int idx = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            ans[idx++] = from;
            for (int adj : graph[from]) {
                degree[adj]--;
                if (degree[adj] == 0) {
                    queue.add(adj);
                }
            }
        }

        if (idx < n) {
            return new int[0];
        }
        return ans;
    }

}
