package tree;

//https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int lastNum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                lastNum = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(lastNum);
        }

        return list;
    }
}
