//TOPICS:
//[Graph]

//TIPS:
//Star node must occur in every edge.
public class _1791_FindCenterOfStarGraph {
    public static int findCenter(int[][] edges) {
        int firstLeft = edges[0][0];
        int firstRight = edges[0][1];
        if (firstLeft == edges[1][0] || firstLeft == edges[1][1] ) {
            return firstLeft;
        } else {
            return firstRight;
        }
    }

    public static int findCenterDegree(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n+1];

        for (int i = 0; i < edges.length; i++) {
            int left = edges[i][0];
            int right = edges[i][1];
            degree[left]++;
            if (degree[left]==n-1) {
                return left;
            }
            degree[right]++;
            if (degree[right]==n-1) {
                return right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n1 = findCenter(new int[][]{{1,2},{2,3},{4,2}});
        int n2 = findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}});
    }
}
