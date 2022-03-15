package dfs;

//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        int[] list = new int[n];

        backtracking(list, 0, 0);
        return ans;
    }

    private void backtracking(int[] list, int len, int i) {
        if (i == n) {
            List<Integer> l = new ArrayList<>(len);
            for (int j = 0; j < len; j++) {
                l.add(list[j]);
            }
            ans.add(l);
            return;
        }
        list[len++] = nums[i];
        backtracking(list, len, i + 1);
        len--;

        backtracking(list, len, i + 1);
    }
}