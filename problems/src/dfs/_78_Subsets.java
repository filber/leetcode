package dfs;

//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        this.nums = nums;
        int[] list = new int[n];
        backtracking(list, 0, 0);
        return ans;
    }

    private void backtracking(int[] list, int len, int i) {
        if (i == n) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                subset.add(list[j]);
            }
            ans.add(subset);
            return;
        }

        // use Ni
        list[len] = nums[i];
        backtracking(list, len + 1, i + 1);

        // skip Ni
        backtracking(list, len, i + 1);
    }
}