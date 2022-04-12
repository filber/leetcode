package tree;

//https://leetcode.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

public class _113_PathSumII {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backtracking(root, targetSum, new ArrayList<>());
        return ans;
    }

    private void backtracking(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                List<Integer> path = new ArrayList<>(list);
                path.add(root.val);
                ans.add(path);
            }
        } else {
            list.add(root.val);
            int sum = targetSum - root.val;
            backtracking(root.left, sum, list);
            backtracking(root.right, sum, list);
            list.remove(list.size() - 1);
        }
    }
}
