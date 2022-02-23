package graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class _210_CourseScheduleII {

    List<Integer>[] edges;
    int[] status;
    int[] empty = new int[0];
    int[] order;
    int idx = 0;

    public int[] findOrder(int n, int[][] prerequisites) {
        status = new int[n];
        edges = new List[n];
        order = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            edges[pre[0]].add(pre[1]);
        }

        for (int i = 0; i < n; i++) {
            if (status[i] == 0) {
                if (!dfs(i)) {
                    return empty;
                }
            }
        }

        return order;
    }

    private boolean dfs(int i) {
        if (status[i] == 2) {
            return true;
        } else if (status[i] == 1) {
            return false;
        }
        status[i] = 1;
        for (int neighbor : edges[i]) {
            if (status[neighbor] == 0 && !dfs(neighbor) || status[neighbor] == 1) {
                return false;
            }
        }

        order[idx++] = i;
        status[i] = 2;
        return true;
    }

}
