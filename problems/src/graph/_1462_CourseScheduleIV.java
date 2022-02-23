package graph;
//https://leetcode.com/problems/course-schedule-iv/

import java.util.*;

public class _1462_CourseScheduleIV {

    List<Integer>[] edges;
    boolean[] complete;
    Set<Integer>[] sets;

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        complete = new boolean[n];
        edges = new List[n];
        sets = new Set[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            sets[i] = new HashSet<>();
        }

        int[] indegree = new int[n];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            indegree[pre[1]]++;
            edges[pre[0]].add(pre[1]);
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                dfs(i);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (sets[query[0]].contains(query[1])) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }

    private void dfs(int i) {
        if (complete[i]) {
            return;
        }

        for (int neighbor : edges[i]) {
            sets[i].add(neighbor);
            dfs(neighbor);
            sets[i].addAll(sets[neighbor]);
        }

        complete[i] = true;
    }
}
