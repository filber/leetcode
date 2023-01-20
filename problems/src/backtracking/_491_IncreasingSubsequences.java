package backtracking;

//https://leetcode.com/problems/increasing-subsequences/

import java.util.*;

public class _491_IncreasingSubsequences {

    List<List<Integer>> ans = new ArrayList<>();
    int n;
    int idx = 0;
    int[] seq;
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        seq = new int[n];
        this.nums = nums;
        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (idx > 1) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < idx; j++) {
                list.add(seq[j]);
            }
            ans.add(list);
        }
        if (i == n) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < n; j++) {
            if (idx > 0 && seq[idx - 1] > nums[j]) continue;
            if (set.contains(nums[j])) continue;
            set.add(nums[j]);
            seq[idx++] = nums[j];
            backtracking(j + 1);
            idx--;
        }
    }
}
