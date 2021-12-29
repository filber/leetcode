//TOPICS:
//[Graph],[Depth-First Search]

public class _547_NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int gCount = 0;
        int n = isConnected.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]==0) {
                gCount++;
                dfs(isConnected, visited, i);
            }
        }
        return gCount;
    }

    public static void dfs(int[][] isConnected, int[] visited, int i) {
        if (visited[i] == 1) {
            return; // already visit
        }
        visited[i] = 1;

        int n = isConnected.length;
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1) {
                dfs(isConnected, visited, j);
            }
        }
    }



    public static void main(String[] args) {
        int n1 = findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        int n2 = findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
        int n3 = findCircleNum(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
        });
        int n4 = findCircleNum(new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1},
        });
    }
}
