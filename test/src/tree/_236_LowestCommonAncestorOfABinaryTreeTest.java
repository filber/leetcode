package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _236_LowestCommonAncestorOfABinaryTreeTest {

    _236_LowestCommonAncestorOfABinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _236_LowestCommonAncestorOfABinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLowestCommonAncestor1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        // [3]->1->8
        TreeNode p = new TreeNode(8);
        // [3]->5->2->4
        TreeNode q = new TreeNode(4);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(3, lca.val);
    }

    @Test
    public void testLowestCommonAncestor2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        // [3]->5
        TreeNode p = new TreeNode(5);
        // [3]->1
        TreeNode q = new TreeNode(1);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(3, lca.val);
    }

    @Test
    public void testLowestCommonAncestor3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        // 3->[5]
        TreeNode p = new TreeNode(5);
        // 3->[5]->2->4
        TreeNode q = new TreeNode(4);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(5, lca.val);
    }

    @Test
    public void testLowestCommonAncestor4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        // 3->[5]->6
        TreeNode p = new TreeNode(6);
        // 3->[5]->2->4
        TreeNode q = new TreeNode(4);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(5, lca.val);
    }

    @Test
    public void testLowestCommonAncestor5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2});
        //[1]
        TreeNode p = new TreeNode(1);
        //[1]->2
        TreeNode q = new TreeNode(2);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(1, lca.val);
    }
}