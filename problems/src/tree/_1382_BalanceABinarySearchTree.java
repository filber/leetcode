package tree;

// https://leetcode.com/problems/balance-a-binary-search-tree/

import java.util.ArrayList;
import java.util.List;

public class _1382_BalanceABinarySearchTree {

    List<Integer> list;

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        midOrderTraverse(root);
        return build(0,list.size()-1);
    }

    private TreeNode build(int start, int end) {
        if(start>end) {
            return null;
        } else if(start == end) {
            return new TreeNode(list.get(start));
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        TreeNode left = build(start,mid-1);
        root.left = left;
        TreeNode right = build(mid+1,end);
        root.right = right;
        return root;
    }

    private void midOrderTraverse(TreeNode root) {
        if(root == null) {
            return;
        }
        midOrderTraverse(root.left);
        list.add(root.val);
        midOrderTraverse(root.right);
    }
}