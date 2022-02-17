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

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        this.n = n;

        dfs(list, k, 0, 1);
        return ans;
    }

    public void dfs(List<Integer> list, int k, int sum, int i) {
        if (sum == n && k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i == 10) {
            return;
        }
        if (k == 0) {
            return;
        }
        if (sum + i > n) {
            // no need to choose i and subsequent numbers
            return;
        }

        // Use i
        list.add(i);
        dfs(list, k - 1, sum + i, i + 1);
        list.remove(list.size() - 1);

        // Not use i
        dfs(list, k, sum, i + 1);
    }
}
