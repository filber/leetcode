package dfs;

//https://leetcode.com/problems/matchsticks-to-square/

import java.util.Arrays;

public class _473_MatchsticksToSquare {

    private static final int MAX_GROUP = 4;

    int[] matchsticks;
    int len;
    boolean[] used;
    int n;

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        n = matchsticks.length;
        if (n < MAX_GROUP) {
            return false;
        }

        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }
        if (sum % MAX_GROUP != 0) {
            return false;
        }

        len = sum / MAX_GROUP;
        used = new boolean[n];
        Arrays.sort(this.matchsticks);
        boolean rst = backtracking(0, 0, n - 1);
        return rst;
    }

    private boolean backtracking(int group, int sum, int i) {
        if (group == MAX_GROUP) {
            return true;
        } else if (sum == len) {
            return backtracking(group + 1, 0, n - 1);
        } else if (sum > len) {
            return false;
        }

        int last = -1;
        for (int j = i; j >= 0; j--) {
            if (used[j] || matchsticks[j] == last) continue;
            // use j
            used[j] = true;
            last = matchsticks[j];
            if (backtracking(group, matchsticks[j] + sum, j - 1)) {
                return true;
            }
            // skip j
            used[j] = false;
        }
        return false;
    }
}
