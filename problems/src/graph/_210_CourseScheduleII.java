package graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class _210_CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        // 0:not visited, 1: try to visit, 2: already visited
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            graph[pre[0]].add(pre[1]);
        }

        int[] order = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                index = traverse(graph, visited, order, index, i);
                if (index == -1) {
                    return new int[]{};
                }
            }
        }
        return order;
    }

    private static int traverse(List<Integer>[] graph, int[] visited, int[] order, int index, int id) {
        if (visited[id]==1) {
            // try to visit
            return -1;
        } else if (visited[id]==2) {
            // already visited
            return index;
        } else {
            visited[id] = 1;
            for (int pre : graph[id]) {
                if (visited[pre] != 2) {
                    index = traverse(graph,visited,order,index,pre);
                    if (index == -1) {
                        return -1;
                    }
                }
            }

            visited[id] = 2;
            order[index] = id;
            return ++index;
        }
    }


    public static void main(String[] args) {
        // [0,1]
        int[] o1 = findOrder(2, new int[][]{{1, 0}});
        // [0,2,1,3]
        int[] o2 = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        // [0]
        int[] o3 = findOrder(1, new int[][]{});
        // []
        int[] o4 = findOrder(2, new int[][]{{1, 0},{0,1}});
        // []
        int[] o5 = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {0, 3}});
    }
}
