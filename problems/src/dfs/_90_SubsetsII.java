package dfs;

import java.util.*;

public class _90_SubsetsII {

    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int[] path;
    int len = 0;
    boolean[] used;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        path = new int[n];
        this.nums = nums;
        Arrays.sort(nums);

        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (i == n) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < len; k++) {
                list.add(path[k]);
            }
            ans.add(list);
            return;
        }

        // NOT USE
        backtracking(i + 1);

        // USE
        // set constraints for USE
        if (i == 0 || nums[i] != nums[i - 1] || used[i - 1]) {
            used[i] = true;
            path[len++] = nums[i];

            backtracking(i + 1);

            used[i] = false;
            len--;
        }
    }
}
