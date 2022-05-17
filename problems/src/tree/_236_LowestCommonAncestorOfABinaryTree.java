package tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

import java.util.Stack;

public class _236_LowestCommonAncestorOfABinaryTree {

    Stack<TreeNode> pStack = new Stack<>();
    boolean pFound = false;

    Stack<TreeNode> qStack = new Stack<>();
    boolean qFound = false;

    TreeNode p;
    TreeNode q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        traverse(root);

        int i = 0;
        while (i < pStack.size() && i < qStack.size() && pStack.get(i) == qStack.get(i)) {
            i++;
        }

        return pStack.get(i - 1);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (!pFound) {
            pStack.push(root);
            pFound = root.val == p.val;
        }

        if (!qFound) {
            qStack.push(root);
            qFound = root.val == q.val;
        }

        if (!pFound || !qFound) {
            traverse(root.left);
            traverse(root.right);
        }

        if (!pFound) {
            pStack.pop();
        }
        if (!qFound) {
            qStack.pop();
        }
    }
}
