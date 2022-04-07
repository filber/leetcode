package tree;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

import java.util.*;

public class _107_BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(levelNodes);
        }

        Collections.reverse(list);
        return list;
    }
}
