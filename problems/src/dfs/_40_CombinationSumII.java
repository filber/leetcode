package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/

public class _40_CombinationSumII {

    List<List<Integer>> ans = new ArrayList<>();
    int n;
    int[] c;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] c, int t) {
        Arrays.sort(c);
        this.n = c.length;
        this.c = c;
        used = new boolean[n];

        backtracking(new ArrayList<>(), n - 1, t);

        return ans;
    }

    private void backtracking(List<Integer> list, int i, int sum) {
        if (sum == 0) {
            ans.add(new ArrayList<>(list));
            return;
        } else if (sum < 0) {
            return;
        } else if (i == -1) {
            return;
        }

        for (int j = i; j >=0; j--) {
            if (j == n-1 || c[j] != c[j + 1] || used[j + 1]) {
                list.add(c[j]);
                used[j] = true;
                backtracking(list, j - 1, sum - c[j]);
                list.remove(list.size() - 1);
                used[j] = false;
            }
        }
    }
}
