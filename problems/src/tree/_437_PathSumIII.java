package tree;

//https://leetcode.com/problems/path-sum-iii/

import java.util.HashMap;
import java.util.Map;

public class _437_PathSumIII {

    int targetSum;
    Map<Integer, Integer> preSum = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        preSum.put(0, 1);
        return backtracking(root, 0);
    }

    private int backtracking(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int cnt = 0;
        cnt += preSum.getOrDefault(sum - targetSum, 0);

        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);

        cnt += backtracking(root.left, sum);
        cnt += backtracking(root.right, sum);

        preSum.put(sum, preSum.get(sum) - 1);
        return cnt;
    }
}
