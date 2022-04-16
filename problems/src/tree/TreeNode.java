package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Integer[] toArray() {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return list.toArray(new Integer[0]);
    }

    public static TreeNode createTreeNode(Integer[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[arr.length];
        nodes[0] = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != null) {
                nodes[i] = new TreeNode(arr[i]);
                if (i % 2 == 0) {
                    int pid = (i - 1) / 2;
                    nodes[pid].right = nodes[i];
                } else {
                    int pid = i / 2;
                    nodes[pid].left = nodes[i];
                }
            }
        }

        return nodes[0];
    }
}
