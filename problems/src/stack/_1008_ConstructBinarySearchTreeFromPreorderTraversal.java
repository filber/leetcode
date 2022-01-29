package stack;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

import java.util.Stack;

//[Monotonic Stack]
public class _1008_ConstructBinarySearchTreeFromPreorderTraversal {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    int[] preorder;
    int index = 0;
    // two pointers
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        return build(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int l, int r) {
        if (l > r || index >= preorder.length) {
            return null;
        }
        int val = preorder[index];
        if (val < l || val > r) {
            return null;
        }
        index++;
        TreeNode root = new TreeNode(val);
        root.left = build(l, val);
        root.right = build(val, r);
        return root;
    }


    public static TreeNode bstFromPreorderStack(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode node = new TreeNode(preorder[i]);
            if (val < stack.peek().val) {
                // link & push
                stack.peek().left = node;
            } else {
                // pop until peek > node
                TreeNode pre = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < val) {
                    pre = stack.pop();
                }
                pre.right = node;
            }
            stack.push(node);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new _1008_ConstructBinarySearchTreeFromPreorderTraversal().
                bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        TreeNode t2 = new _1008_ConstructBinarySearchTreeFromPreorderTraversal().
                bstFromPreorder(new int[]{1, 3});
    }
}
