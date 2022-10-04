package tree;

//https://leetcode.com/problems/path-sum-iii/

import java.util.HashMap;
import java.util.Map;

public class _437_PathSumIII {


    int count = 0;
    Map<Long, Integer> map = new HashMap<>();
    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        this.targetSum = targetSum;
        backtracking(root, 0);
        return count;
    }

    private void backtracking(TreeNode root, long pathSum) {
        if (root == null) {
            return;
        }
        pathSum += root.val;

        count += map.getOrDefault(pathSum - targetSum, 0);

        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        backtracking(root.left, pathSum);
        backtracking(root.right, pathSum);
        map.put(pathSum, map.getOrDefault(pathSum, 0) - 1);
    }
}
