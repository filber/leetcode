package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _235_LowestCommonAncestorOfABinarySearchTreeTest {

    _235_LowestCommonAncestorOfABinarySearchTree target = null;

    @Before
    public void before() throws Exception {
        target = new _235_LowestCommonAncestorOfABinarySearchTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLowestCommonAncestor1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(6, lca.val);
    }

    @Test
    public void testLowestCommonAncestor2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(9);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(8, lca.val);
    }

    @Test
    public void testLowestCommonAncestor3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(0);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(2, lca.val);
    }

    @Test
    public void testLowestCommonAncestor4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(4, lca.val);
    }

    @Test
    public void testLowestCommonAncestor5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{2, 1});
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        TreeNode lca = target.lowestCommonAncestor(root, p, q);
        assertEquals(2, lca.val);
    }
}
