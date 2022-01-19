package graph;

// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

import java.util.ArrayList;
import java.util.List;

public class _1557_MinimumNumberOfVerticesToReachAllNodes {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for (List<Integer> e : edges) {
            inDegree[e.get(1)]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> e_0_1 = new ArrayList<>();
        edges.add(e_0_1);
        e_0_1.add(0);
        e_0_1.add(1);
        List<Integer> e_0_2 = new ArrayList<>();
        edges.add(e_0_2);
        e_0_2.add(0);
        e_0_2.add(2);
        List<Integer> e_2_5 = new ArrayList<>();
        edges.add(e_2_5);
        e_2_5.add(2);
        e_2_5.add(5);
        List<Integer> e_3_4 = new ArrayList<>();
        edges.add(e_3_4);
        e_3_4.add(3);
        e_3_4.add(4);
        List<Integer> e_4_2 = new ArrayList<>();
        edges.add(e_4_2);
        e_4_2.add(4);
        e_4_2.add(2);

        List<Integer> v1 = findSmallestSetOfVertices(6, edges);
    }
}
