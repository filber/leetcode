package array_matrix;

// https://leetcode.com/problems/richest-customer-wealth/

public class _1672_RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int m = accounts.length;
        int n = accounts[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                accounts[i][j] += accounts[i][j - 1];
            }
            maxWealth = Math.max(maxWealth, accounts[i][n - 1]);
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        // 6
        int m1 = maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}});
        // 10
        int m2 = maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}});
        // 17
        int m3 = maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}});
    }
}
