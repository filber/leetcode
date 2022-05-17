package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _110_BalancedBinaryTreeTest {

    _110_BalancedBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _110_BalancedBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsBalanced1() throws Exception {
        boolean is = target.isBalanced(null);
        assertTrue(is);
    }

    @Test
    public void testIsBalanced2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        boolean is = target.isBalanced(root);
        assertTrue(is);
    }

    @Test
    public void testIsBalanced3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, null, null, 4, 4});
        boolean is = target.isBalanced(root);
        assertFalse(is);
    }
}
