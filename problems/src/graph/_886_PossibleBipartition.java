package graph;

//https://leetcode.com/problems/possible-bipartition/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _886_PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 1. Construct Graph
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] group = new int[n + 1];

        // 2. Traverse all contours
        for (int i = 1; i <= n; i++) {
            if (group[i] == 0) {
                if (!bfs(graph, group, i)) {
                    return false;
                }
            }
        }

        // no violations found
        return true;
    }

    private boolean bfs(List<Integer>[] graph, int[] group, int i) {
        group[i] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        int supposeGroup = 2;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int j = 0; j < sz; j++) {
                int node = queue.poll();
                for (int adj : graph[node]) {
                    if (group[adj] == 0) {
                        group[adj] = supposeGroup;
                        queue.add(adj);
                    } else if (group[adj] != supposeGroup) {
                        return false;
                    }
                }
            }
            supposeGroup = 3 - supposeGroup;
        }
        return true;
    }
}
