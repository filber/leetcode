package dfs;

//https://leetcode.com/problems/subsets-ii/

import java.util.*;

public class _90_SubsetsII {

    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int[] candidate;
    int len = 0;
    boolean[] used;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        this.nums = nums;
        used = new boolean[n];
        candidate = new int[n];
        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (i == n) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                list.add(candidate[j]);
            }
            ans.add(list);
            return;
        }

        if (i == 0 || nums[i] != nums[i - 1] || used[i - 1]) {
            // Use i
            used[i] = true;
            backtracking(i + 1);
            used[i] = false;
        }

        // Not use i
        backtracking(i + 1);
    }
}
