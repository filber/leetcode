import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TOPICS:
// [Graph], [BFS], [Backtracking], [DFS]
public class _797_AllPathsFromSourceToTarget {
    // Backtracking
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(graph, paths, path, 0);
        return paths;
    }

    public static void backtrack(int[][] graph, List<List<Integer>> paths, LinkedList<Integer> path, int node) {
        path.add(node);
        if (node== graph.length-1) {
            paths.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < graph[node].length; i++) {
                backtrack(graph, paths, path, graph[node][i]);
            }
        }
        path.removeLast();
    }

    public static List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        Queue<ArrayList<Integer>> pathQueue = new LinkedList<>();
        List<List<Integer>> allPaths = new LinkedList<>();
        int endNode = graph.length - 1;

        nodeQueue.add(0);
        pathQueue.add(new ArrayList<>());

        while (!nodeQueue.isEmpty()) {
            Integer node = nodeQueue.poll();
            ArrayList<Integer> path = pathQueue.poll();
            path.add(node);
            if (node == endNode) {
                // end of the path
                allPaths.add(path);
                continue;
            }
            else if (graph[node].length>=1) {
                for (int i = 0; i < graph[node].length; i++) {
                    pathQueue.add((ArrayList<Integer>) path.clone());
                }
            }

            for (int i = 0; i < graph[node].length; i++) {
                nodeQueue.add(graph[node][i]);
            }
        }

        return allPaths;
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
