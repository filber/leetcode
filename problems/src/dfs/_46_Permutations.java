package dfs;

//https://leetcode.com/problems/permutations/

import java.util.*;

public class _46_Permutations {

    int[] nums;
    boolean[] used;
    int[] permutation;
    int n;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        permutation = new int[n];
        used = new boolean[n];
        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (i == n) {
            List<Integer> list = new ArrayList<>();
            for (int val : permutation) {
                list.add(val);
            }
            ans.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!used[j]) {
                permutation[i] = nums[j];
                used[j] = true;
                backtracking(i + 1);
                used[j] = false;
            }
        }
    }
}
