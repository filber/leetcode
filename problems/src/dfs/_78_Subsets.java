package dfs;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    // Backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> list, int[] nums, int i) {
        // 0. Guard condition
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 1. Not use Ni
        backtracking(ans, list, nums, i + 1);

        // 2. Use Ni
        // set states
        list.add(nums[i]);
        // backtracking
        backtracking(ans, list, nums, i + 1);
        // reverse states
        list.remove(list.size() - 1);
    }
}
