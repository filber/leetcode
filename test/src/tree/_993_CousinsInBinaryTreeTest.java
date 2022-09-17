package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _993_CousinsInBinaryTreeTest {

    _993_CousinsInBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _993_CousinsInBinaryTree();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsCousins1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3, 4});
        boolean cousins = target.isCousins(root, 3, 4);
        assertFalse(cousins);
    }

    @Test
    public void testIsCousins2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3, null, 4, null, 5});
        boolean cousins = target.isCousins(root, 5, 4);
        assertTrue(cousins);
    }

    @Test
    public void testIsCousins3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3, null, 4});
        boolean cousins = target.isCousins(root, 2, 3);
        assertFalse(cousins);
    }
}
