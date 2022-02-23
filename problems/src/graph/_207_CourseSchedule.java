package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/course-schedule/
public class _207_CourseSchedule {

    List<Integer>[] edges;

    // 0:not visit, 1:try to visit, 2: already visited
    int[] status;

    public boolean canFinish(int n, int[][] prerequisites) {
        edges = new List[n];
        status = new int[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            edges[pre[0]].add(pre[1]);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int id = prerequisites[i][0];
            if (status[id] == 0) {
                if (!dfs(id)) {
                    return false;
                }
            }
        }

        return true;
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

        status[i] = 2;
        return true;
    }
}
