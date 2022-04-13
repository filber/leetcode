package tree;

//https://leetcode.com/problems/unique-binary-search-trees/

public class _96_UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                int leftCnt = dp[j];
                int rightCnt = dp[i - 1 - j];
                dp[i] += leftCnt * rightCnt;
            }
        }
        return dp[n];
    }
}
