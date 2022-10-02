package dfs;

//https://leetcode.com/problems/subsets-ii/

import java.util.*;

public class _90_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, new boolean[nums.length], new ArrayList<>(), ans, 0);
        return ans;
    }

    private void backtracking(int[] nums,
                              boolean[] used,
                              List<Integer> seq,
                              List<List<Integer>> ans,
                              int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(seq));
            return;
        }
        backtracking(nums, used, seq, ans, i + 1);
        if (i == 0 || nums[i - 1] != nums[i] || used[i - 1]) {
            used[i] = true;
            seq.add(nums[i]);
            backtracking(nums, used, seq, ans, i + 1);
            used[i] = false;
            seq.remove(seq.size() - 1);
        }
    }
}
