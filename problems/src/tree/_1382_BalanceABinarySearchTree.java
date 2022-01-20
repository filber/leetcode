package tree;

// https://leetcode.com/problems/balance-a-binary-search-tree/

import java.util.ArrayList;

public class _1382_BalanceABinarySearchTree {

    public static class TreeNode {
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
    }

    public static TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        root = constructTree(list, 0, list.size() - 1);
        return root;
    }

    private static TreeNode constructTree(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(middle));
        TreeNode left = constructTree(list,start,middle-1);
        TreeNode right = constructTree(list,middle+1,end);
        root.left = left;
        root.right = right;
        return root;
    }

    private static void inOrderTraverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }


    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1 = balanceBST(r1);

        TreeNode r2 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        r2 = balanceBST(r2);

        TreeNode r3 = new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null,
                                new TreeNode(4))));
        r3 = balanceBST(r3);
    }
}
