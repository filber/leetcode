package dfs;

//https://leetcode.com/problems/permutations/

import java.util.*;

public class _46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] seq = new int[nums.length];
        boolean[] used = new boolean[nums.length];
        backtracking(ans, nums, used, seq, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, int[] nums, boolean[] used, int[] seq, int i) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>(seq.length);
            for (int elem : seq) {
                list.add(elem);
            }
            ans.add(list);
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) continue;

            used[j] = true;
            seq[i] = nums[j];
            backtracking(ans, nums, used, seq, i + 1);
            used[j] = false;
        }
    }

}
