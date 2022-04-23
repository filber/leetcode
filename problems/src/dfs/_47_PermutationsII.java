package dfs;

//https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (j > 0 && nums[j] == nums[j - 1] && !used[j - 1]) continue;
            used[j] = true;
            seq[i] = nums[j];
            backtracking(ans, nums, used, seq, i + 1);
            used[j] = false;
        }
    }

}
