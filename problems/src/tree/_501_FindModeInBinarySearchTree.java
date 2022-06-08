package tree;

//https://leetcode.com/problems/find-mode-in-binary-search-tree/

import java.util.ArrayList;

public class _501_FindModeInBinarySearchTree {

    ArrayList<Integer> list = new ArrayList<>();

    int maxCount = 1;
    int curCount = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (pre != null) {
            if (pre.val == root.val) {
                curCount++;
                if (curCount == maxCount) {
                    list.add(root.val);
                } else if (curCount > maxCount) {
                    maxCount = curCount;
                    list.clear();
                    list.add(root.val);
                }
            } else {
                curCount = 1;
            }
        } else {
            curCount = 1;
            list.add(root.val);
        }
        pre = root;
        traverse(root.right);
    }
}
