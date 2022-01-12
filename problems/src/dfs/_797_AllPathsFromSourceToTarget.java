package dfs;

// https://leetcode.com/problems/all-paths-from-source-to-target/
import java.util.ArrayList;
import java.util.List;

// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
// find all possible paths from node 0 to node n - 1 and return them in any order.

// TOPICS:
// [Graph], [BFS], [Backtracking], [DFS]
public class _797_AllPathsFromSourceToTarget {
    // Backtracking
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph,res,0,new ArrayList<Integer>());
        return res;
    }

    private static void dfs(int[][] graph,
                            List<List<Integer>> res,
                            int i,
                            List<Integer> list) {
        int n = graph.length;
        list.add(i);
        if (i == n - 1) {
            res.add(new ArrayList<>(list));
        } else {
            for (int j = 0; j < graph[i].length; j++) {
                dfs(graph, res, graph[i][j], list);
            }
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[][] g1 = new int[][]{{1,2},{3},{3},{}};
        List<List<Integer>> p1 = allPathsSourceTarget(g1);

        int[][] g2 = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> p2 = allPathsSourceTarget(g2);

        int[][] g3 = new int[][]{{2},{},{1}};
        List<List<Integer>> p3 = allPathsSourceTarget(g3);
    }
}
