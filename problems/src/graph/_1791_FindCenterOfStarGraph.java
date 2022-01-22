package graph;

// https://leetcode.com/problems/find-center-of-star-graph/

public class _1791_FindCenterOfStarGraph {

    //Star node must occur in every edge.
    public static int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];
        if (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1]) {
            return firstEdge[0];
        } else {
            return firstEdge[1];
        }
    }


    public static void main(String[] args) {
        int n1 = findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}});
        int n2 = findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}});
    }
}
