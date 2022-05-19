package dp;

//https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

    List<List<Integer>> ans = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtracking(new int[k], 0, 1);
        return ans;
    }

    private void backtracking(int[] seq, int i, int start) {
        if (i == k) {
            List<Integer> list = new ArrayList<>(k);
            for (int val : seq) {
                list.add(val);
            }
            ans.add(list);
            return;
        }
        if (start > n) {
            return;
        }

        for (int j = start; j <= n; j++) {
            seq[i] = j;
            backtracking(seq, i + 1, j + 1);
        }
    }
}
