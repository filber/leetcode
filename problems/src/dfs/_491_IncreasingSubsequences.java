package dfs;

//https://leetcode.com/problems/increasing-subsequences/

import java.util.*;

public class _491_IncreasingSubsequences {

    List<List<Integer>> ans = new ArrayList<>();

    int[] nums;
    int n;
    int[] seq;
    int idx = 0;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        seq = new int[n];

        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (idx > 1) {
            List<Integer> list = new ArrayList<>(idx);
            for (int j = 0; j < idx; j++) {
                list.add(seq[j]);
            }
            ans.add(list);
        }
        if (i == n) {
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int j = i; j < n; j++) {
            if (idx > 0 && seq[idx - 1] > nums[j]) continue;
            if (used.contains(nums[j])) continue;
            used.add(nums[j]);
            seq[idx++] = nums[j];
            backtracking(j + 1);
            idx--;
        }
    }
}
