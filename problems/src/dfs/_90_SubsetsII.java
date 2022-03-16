package dfs;

import java.util.*;

public class _90_SubsetsII {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    ArrayList<Integer> path = new ArrayList<>();// 用来存放符合条件结果
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
