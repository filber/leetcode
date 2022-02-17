package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/

public class _39_CombinationSum {

    private List<List<Integer>> ans = new ArrayList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int t) {
        target = t;

        Arrays.sort(candidates);
        this.candidates = candidates;

        List<Integer> list = new ArrayList<>();
        dfs(list, 0, 0);
        return ans;
    }

    private void dfs(List<Integer> list, int i, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i == candidates.length) {
            return;
        }
        if (sum + candidates[i] > target) {
            // can't choose Ci and subsequent numbers
            return;
        }


        // use Ci
        list.add(candidates[i]);
        dfs(list, i, sum + candidates[i]);
        list.remove(list.size() - 1);

        // skip Ci
        dfs(list, i + 1, sum);
    }
}
