package tree;

//https://leetcode.com/problems/find-mode-in-binary-search-tree/

import java.util.ArrayList;

public class _501_FindModeInBinarySearchTree {

    ArrayList<Integer> list = new ArrayList<>();
    int cursor = 0;

    int maxCount = 1;
    int curCount = 0;
    int pre = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        traverse(root);

        int[] ans = new int[cursor];
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

        if (root.val == pre) {
            curCount++;
        } else {
            curCount = 1;
            pre = root.val;
        }

        if (curCount > maxCount) {
            maxCount = curCount;
            cursor = 0;
            list.add(cursor++, root.val);
        } else if (curCount == maxCount) {
            list.add(cursor++, root.val);
        }

        traverse(root.right);
    }

}
