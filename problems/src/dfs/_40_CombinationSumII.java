package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/

public class _40_CombinationSumII {

    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates;
    int target;
    int[] cnt = new int[101];
    int n = 0;

    public List<List<Integer>> combinationSum2(int[] c, int t) {
        Arrays.sort(c);

        candidates = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            int num = c[i];
            cnt[num]++;
            // remove duplicates
            if (n == 0 || (n > 0 && num != candidates[n - 1])) {
                candidates[n++] = num;
            }
        }

        target = t;
        List<Integer> list = new ArrayList<>();
        dfs(list, 0, 0);
        return ans;
    }

    private void dfs(List<Integer> list, int i, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i == n) {
            return;
        }
        if (sum + candidates[i] > target) {
            // no need to choose i and subsequent numbers
            return;
        }

        if (cnt[candidates[i]] != 0) {
            // use i
            list.add(candidates[i]);
            cnt[candidates[i]]--;
            dfs(list, i, sum + candidates[i]);
            cnt[candidates[i]]++;
            list.remove(list.size() - 1);
        }

        // not use i
        dfs(list, i + 1, sum);
    }
}
