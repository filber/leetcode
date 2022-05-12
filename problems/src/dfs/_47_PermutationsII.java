package dfs;

//https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {

    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int n;
    boolean[] used;
    int[] seq;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        used = new boolean[n];
        seq = new int[n];
        Arrays.sort(nums);

        backtracking(0);

        return ans;
    }

    private void backtracking(int i) {
        if (i == n) {
            List<Integer> list = new ArrayList<>();
            for (int val : seq) {
                list.add(val);
            }
            ans.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (used[j]) {
                continue;
            }
            if (j > 0 && nums[j - 1] == nums[j] && !used[j - 1]) {
                continue;
            }
            seq[i] = nums[j];
            used[j] = true;
            backtracking(i + 1);
            used[j] = false;
        }
    }

}
