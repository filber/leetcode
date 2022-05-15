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

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            if (level == maxLevel) {
                sum += node.val;
            } else if (level > maxLevel) {
                sum = node.val;
                maxLevel = level;
            }
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
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
