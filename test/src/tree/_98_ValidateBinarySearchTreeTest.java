package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _98_ValidateBinarySearchTreeTest {

    _98_ValidateBinarySearchTree target = null;

    @Before
    public void before() throws Exception {
        target = new _98_ValidateBinarySearchTree();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsValidBST1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{2, 1, 3});
        boolean isValid = target.isValidBST(root);
        assertTrue(isValid);
    }

    @Test
    public void testIsValidBST2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 1, 4, null, null, 3, 6});
        boolean isValid = target.isValidBST(root);
        assertFalse(isValid);
    }

    @Test
    public void testIsValidBST3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 4, 6, 3});
        boolean isValid = target.isValidBST(root);
        assertTrue(isValid);
    }

    @Test
    public void testIsValidBST4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 1});
        boolean isValid = target.isValidBST(root);
        assertFalse(isValid);
    }
}
