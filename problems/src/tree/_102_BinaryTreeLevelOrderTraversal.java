package tree;

//https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.*;

public class _102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> rst = new ArrayList<>();
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            rst.add(layer);
        }
        return rst;
    }
}
