package dfs;

import java.util.*;

public class _90_SubsetsII {

    List<List<Integer>> ans = new ArrayList<>();
    int[] path;
    int len = 0;
    boolean[] used;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.n = nums.length;
        path = new int[n];
        used = new boolean[n];
        Arrays.sort(nums);

        backtracking(nums, 0);

        return ans;
    }

    private void backtracking(int[] nums, int i) {
        List<Integer> list = new ArrayList<>(len);
        for (int j = 0; j < len; j++) {
            list.add(path[j]);
        }

        ans.add(list);

        if (i == n) {
            return;
        }

        for (int k = i; k < n; k++) {
            if (k > 0 && nums[k - 1] == nums[k] && !used[k - 1]) {
                continue;
            }
            used[k] = true;
            path[len++] = nums[k];

            backtracking(nums, k + 1);

            len--;
            used[k] = false;
        }
    }
}
