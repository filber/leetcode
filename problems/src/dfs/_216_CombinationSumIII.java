package dfs;

//https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIII {

    // Constraints:
    //        2 <= k <= 9
    //        1 <= n <= 60

    private List<List<Integer>> ans = new ArrayList<>();
    private int n;
    private boolean[] used = new boolean[10];

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        int[] sequence = new int[k];
        backtracking(sequence, 0, 0, 1);

        return ans;
    }

    private void backtracking(int[] sequence, int sum, int i, int start) {
        if (i == sequence.length) {
            if (sum == n) {
                List<Integer> list = new ArrayList<>(sequence.length);
                for (int val : sequence) {
                    list.add(val);
                }
                ans.add(list);
            }
            return;
        } else if (sum >= n) {
            return;
        }

        for (int j = start; j <= 9; j++) {
            if (used[j]) {
                continue;
            }
            sequence[i] = j;
            used[j] = true;
            backtracking(sequence, sum + j, i + 1, j + 1);
            used[j] = false;
        }
    }

}
