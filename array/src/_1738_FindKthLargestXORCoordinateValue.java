import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// TIPS:
// PriorityQueue for duplicating values
// BitSet for non-repetitive values
// Arrays.sort for too many values
public class _1738_FindKthLargestXORCoordinateValue {
    public static int kthLargestValueV1(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(m * n
                , new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        // 1. Init DP & BitSet
        int[][] dp = new int[m][n];


        // 2. Construct DP
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0) {
                    // first element
                    dp[0][0] = matrix[0][0];
                } else if (i==0) {
                    // element of the first row
                    dp[0][j] = dp[0][j - 1] ^ matrix[0][j];
                } else if (j==0) {
                    // element of the first column
                    dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
                } else {
                    int topLeft = dp[i-1][j-1];
                    int top = dp[i-1][j] ^ topLeft;
                    int left = dp[i][j-1] ^ topLeft;
                    dp[i][j] = topLeft ^ top ^ left ^ matrix[i][j];
                }
                priorityQueue.add(dp[i][j]);
            }
        }

        // 3. Find Kth largest coordinate value
        int val = priorityQueue.peek();
        for (int i = 0; i < k; i++) {
            val = priorityQueue.poll();
        }

        return val;
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] coordinate = new int[m * n];

        // 1. Init DP
        int[][] dp = new int[m][n];

        // 2. Construct DP
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0) {
                    // first element
                    dp[0][0] = matrix[0][0];
                } else if (i==0) {
                    // element of the first row
                    dp[0][j] = dp[0][j - 1] ^ matrix[0][j];
                } else if (j==0) {
                    // element of the first column
                    dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
                } else {
                    int topLeft = dp[i-1][j-1];
                    int top = dp[i-1][j] ^ topLeft;
                    int left = dp[i][j-1] ^ topLeft;
                    dp[i][j] = topLeft ^ top ^ left ^ matrix[i][j];
                }
                coordinate[i * n + j] = dp[i][j];
            }
        }

        // 3. Find Kth largest coordinate value
        Arrays.sort(coordinate);
        int val = coordinate[coordinate.length - k];
        return val;
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{{4}};
        int m1_1 = kthLargestValue(m1,1);

        int[][] m2 = new int[][]{{5,2},{1,6}};
        int m2_1 = kthLargestValue(m2,1);
        int m2_2 = kthLargestValue(m2,2);
        int m2_3 = kthLargestValue(m2,4);

        int[][] m3 = new int[][]{{10,9,5},{2,0,4},{1,0,9},{3,4,8}};
        int m3_1 = kthLargestValue(m3,10);
    }
}
