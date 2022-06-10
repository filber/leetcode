package dfs;

//https://leetcode.com/problems/increasing-subsequences/

import java.util.*;

public class _491_IncreasingSubsequences {

    List<List<Integer>> ans = new ArrayList<>();

    int[] nums;
    int n;
    int[] seq;
    int idx = -1;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        n = nums.length;
        seq = new int[n];
        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (idx > 0) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k <= idx; k++) {
                list.add(seq[k]);
            }
            ans.add(list);
        }
        if (i == n) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int j = i; j < n; j++) {
            int val = nums[j];
            if (idx != -1 && seq[idx] > val) continue;
            if (set.contains(val)) continue;
            set.add(val);
            seq[++idx] = val;
            backtracking(j + 1);
            idx--;
        }
    }
}
