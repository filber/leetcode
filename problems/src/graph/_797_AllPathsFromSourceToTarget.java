package graph;

// https://leetcode.com/problems/all-paths-from-source-to-target/
import java.util.ArrayList;
import java.util.List;


public class _797_AllPathsFromSourceToTarget {

    private List<List<Integer>> ans = new ArrayList<>();
    private int[][] graph;
    private int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        this.graph = graph;
        List<Integer> list = new ArrayList<>();
        backtracking(list, 0);
        return ans;
    }

    private void backtracking(List<Integer> list, int i) {
        if (i == n - 1) {
            // reach last node
            list.add(i);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        // set states
        list.add(i);

        int[] edges = graph[i];
        for (int j = 0; j < edges.length; j++) {
            backtracking(list, edges[j]);
        }

        list.remove(list.size()-1);
    }

}
