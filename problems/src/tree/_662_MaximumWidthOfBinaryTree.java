package tree;

//https://leetcode.com/problems/maximum-width-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class _662_MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().val;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = node.val;
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    queue.offer(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }

        return maxWidth;
    }
}
