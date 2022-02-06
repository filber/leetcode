package graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/
public class _207_CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 0: not visited
        // 1: try to visit
        // 2: already visited
        int[] visited = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            graph[pre[0]].add(pre[1]);
        }

        // Learn all courses
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            int cid = pre[0];
            if (visited[cid] == 0) {
                if (isCyclic(visited, graph, cid)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isCyclic(int[] visi, List<Integer>[] graph, int cur) {
        if (visi[cur] == 1)
            return true;

        visi[cur] = 1;
        for (int i = 0; i < graph[cur].size(); i++) {
            if (visi[graph[cur].get(i)] != 2)
                if (isCyclic(visi, graph, graph[cur].get(i)))
                    return true;
        }
        visi[cur] = 2;
        return false;
    }

    public static void main(String[] args) {
        boolean f1 = canFinish(2, new int[][]{{1, 0}});

        boolean f2 = canFinish(2, new int[][]{{1, 0}, {0, 1}});

        boolean f3 = canFinish(2, new int[][]{});

        boolean f4 = canFinish(5, new int[][]{
                {1, 0},
                {1, 4},
                {0, 3},
                {4, 3},
        });

        boolean f5 = canFinish(5, new int[][]{
                {1, 0},
                {1, 4},
                {0, 3},
                {4, 3},
                {3, 1},
        });
    }
}
