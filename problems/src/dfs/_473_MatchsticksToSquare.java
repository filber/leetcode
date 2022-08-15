package dfs;

//https://leetcode.com/problems/matchsticks-to-square/

import java.util.Arrays;

public class _473_MatchsticksToSquare {

    private static final int MAX_GROUP = 4;

    int[] M;
    int EDGE;
    boolean[] used;
    int n;

    public boolean makesquare(int[] matchsticks) {
        n = matchsticks.length;
        if (n < MAX_GROUP) {
            return false;
        }
        used = new boolean[n];
        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }
        if (sum % MAX_GROUP != 0) {
            return false;
        }

        EDGE = sum / MAX_GROUP;
        Arrays.sort(matchsticks);
        this.M = matchsticks;
        return backtracking(0, 0, n - 1);
    }

    private boolean backtracking(int group, int curEdge, int i) {
        if (group == MAX_GROUP) {
            return true;
        } else if (curEdge == EDGE) {
            return backtracking(group + 1, 0, n - 1);
        } else if (curEdge > EDGE) {
            return false;
        }
        int last = -1;
        for (int j = i; j >= 0; j--) {
            if (used[j] || last == M[j]) {
                continue;
            }
            used[j] = true;
            last = M[j];
            if (backtracking(group, curEdge + M[j], j - 1)) {
                return true;
            }
            used[j] = false;
        }
        return false;
    }
}
