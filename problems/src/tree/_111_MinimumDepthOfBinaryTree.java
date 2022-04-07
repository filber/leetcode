package tree;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/

import java.util.ArrayDeque;
import java.util.Queue;

public class _111_MinimumDepthOfBinaryTree {


    // BFS
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        int curLevelCnt = 1;
        int nextLevelCnt = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevelCnt--;
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                queue.add(node.left);
                nextLevelCnt++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelCnt++;
            }

            if (curLevelCnt == 0) {
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
                level++;
            }
        }
        return level;
    }

    //DFS
    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
