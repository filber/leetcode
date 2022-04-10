package tree;

//https://leetcode.com/problems/path-sum-iii/

import java.util.HashMap;
import java.util.Map;

public class _437_PathSumIII {

    int targetSum;
    Map<Integer, Integer> preSum = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        preSum.put(0, 1);
        this.targetSum = targetSum;

        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int pathSum) {
        if (node == null) {
            return 0;
        }

        pathSum += node.val;

        int paths = 0;
        paths += preSum.getOrDefault(pathSum - targetSum, 0);

        // before entering left&right subtree,
        // current path will be their prefix sum
        preSum.put(pathSum, preSum.getOrDefault(pathSum, 0) + 1);

        paths += dfs(node.left, pathSum);
        paths += dfs(node.right, pathSum);

        // after exiting from left&right subtree,
        // current path won't be prefix sum of other paths
        preSum.put(pathSum, preSum.getOrDefault(pathSum, 0) - 1);

        return paths;
    }
}
