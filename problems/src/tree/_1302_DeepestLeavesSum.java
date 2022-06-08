package tree;

//https://leetcode.com/problems/deepest-leaves-sum/

import java.util.ArrayDeque;
import java.util.Queue;

public class _1302_DeepestLeavesSum {

    int maxLevel = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == maxLevel) {
            sum += root.val;
        } else if (level > maxLevel) {
            sum = root.val;
            maxLevel = level;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


    public int deepestLeavesSumBFS(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }
}
