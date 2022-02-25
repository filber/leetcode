package dfs;

//https://leetcode.com/problems/n-queens-ii/

public class _52_NQueensII {

    int n;
    boolean[] row;
    boolean[] col;
    boolean[] slash;
    boolean[] backslash;
    int ans = 0;

    public int totalNQueens(int n) {
        this.n = n;
        row = new boolean[n];
        col = new boolean[n];
        slash = new boolean[2 * n - 1];
        backslash = new boolean[2 * n - 1];

        dfs(0);

        return ans;
    }

    private void dfs(int i) {
        if (i == n) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            int slashIdx = i + j;
            int blackIdx = j - i + n - 1;
            if (row[i] || col[j] || slash[slashIdx] || backslash[blackIdx]) {
                continue;
            }
            row[i] = col[j] = slash[slashIdx] = backslash[blackIdx] = true;
            dfs(i + 1);
            row[i] = col[j] = slash[slashIdx] = backslash[blackIdx] = false;
        }
    }
}
