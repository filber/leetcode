package dfs;//TOPICS:
//[Graph],[Depth-First Search]

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-provinces/
public class _547_NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int[] root = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i; // set root to self
            size[i] = 1; // set size to 1
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(root, size, i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findRoot(root, i)); // add root node to set
        }
        return set.size();
    }

    private static void union(int[] root,int[] size, int p, int q){
        int pid = findRoot(root, p);
        int qid = findRoot(root, q);
        if (size[pid] < size[qid]) {
            root[pid] = qid;
            size[qid] += size[pid];
        } else {
            root[qid] = pid;
            size[pid] += size[qid];
        }
    }

    private static int findRoot(int[] root, int i) {
        while (i != root[i]) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }

    public static int findCircleNumDFS(int[][] isConnected) {
        int n= isConnected.length;
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt ++;
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
        return cnt;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i) {
        // start from 0!
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j]) {
                if (isConnected[i][j] == 1) {
                    visited[j] = true;
                    dfs(isConnected, visited, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        int n1 = findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}); // 2
        int n2 = findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}); // 3
        int n3 = findCircleNum(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
        }); // 2
        int n4 = findCircleNum(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1},
        }); // 1

        int n5 = findCircleNum(new int[][]{
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}
        }); // 3
    }
}
