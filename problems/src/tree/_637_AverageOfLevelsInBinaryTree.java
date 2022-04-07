package tree;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _637_AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double avg = 0;
            int n = 0;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                avg = (avg * n + node.val) / (n + 1);
                n++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(avg);
        }

        return list;
    }
}
