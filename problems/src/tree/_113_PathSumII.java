package tree;

//https://leetcode.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

public class _113_PathSumII {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ans;
        }
        dfs(new ArrayList<>(), root, targetSum);
        return ans;
    }

    private void dfs(List<Integer> list, TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                List<Integer> path = new ArrayList<>(list);
                path.add(node.val);
                ans.add(path);
            }
            return;
        }

        if (node.left != null) {
            list.add(node.val);
            dfs(list, node.left, sum - node.val);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            list.add(node.val);
            dfs(list, node.right, sum - node.val);
            list.remove(list.size() - 1);
        }
    }
}
