package graph;
//https://leetcode.com/problems/course-schedule-iv/

import java.util.*;

public class _1462_CourseScheduleIV {

    public static List<Boolean> checkIfPrerequisiteBFS(int n, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[n];
        Set<Integer>[] adj = new Set[n];
        Set<Integer>[] pre = new Set[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
            pre[i] = new HashSet<>();
        }

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[1]]++;
            adj[prerequisite[0]].add(prerequisite[1]);
        }

        // store nodes of inDegree==0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // Breadth-First Search
        while (!queue.isEmpty()) {
            int node = queue.poll();
            Set<Integer> set = adj[node];
            for (int next : set) {
                pre[next].add(node);
                pre[next].addAll(pre[node]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            ans.add(pre[query[1]].contains(query[0]));
        }
        return ans;
    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Set<Integer>[] preSet = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preSet[i] = new HashSet<>();
        }

        for (int[] pre : prerequisites) {
            preSet[pre[0]].add(pre[1]);
        }

        boolean[] mem = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(preSet, mem, i);
        }

        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            ans.add(preSet[query[0]].contains(query[1]));
        }
        return ans;
    }

    private static Set<Integer> dfs(Set<Integer>[] preSet, boolean[] mem, int id) {
        if (mem[id]) {
            return preSet[id];
        }
        Set<Integer> set = new HashSet<>();
        for (int course : preSet[id]) {
            set.addAll(dfs(preSet, mem, course));
        }
        mem[id] = true;
        preSet[id].addAll(set);
        return preSet[id];
    }

    public static void main(String[] args) {
        // [false,true]
        List<Boolean> l1 = checkIfPrerequisite(
                2,
                new int[][]{{1, 0}},
                new int[][]{{0, 1}, {1, 0}});

        // [false,false]
        List<Boolean> l2 = checkIfPrerequisite(
                2,
                new int[][]{},
                new int[][]{{0, 1}, {1, 0}});

        // [true,true]
        List<Boolean> l3 = checkIfPrerequisite(
                3,
                new int[][]{{1, 2}, {1, 0}, {2, 0}},
                new int[][]{{1, 0}, {1, 2}});
    }
}
