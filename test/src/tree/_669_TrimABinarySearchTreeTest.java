package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _669_TrimABinarySearchTreeTest {

    _669_TrimABinarySearchTree target = null;

    @Before
    public void before() throws Exception {
        target = new _669_TrimABinarySearchTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTrimBST1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 0, 2});
        TreeNode trimmed = target.trimBST(root, 1, 2);
        assertNull(trimmed.left);
    }

    @Test
    public void testTrimBST2() throws Exception {

        TreeNode root = TreeNode.createTreeNode(
                new Integer[]{3, 0, 4, null, 2, null, null, null, null, 1});
        TreeNode trimmed = target.trimBST(root, 1, 3);

        assertNull(trimmed.right);
        assertEquals(2, trimmed.left.val);
        assertEquals(1, trimmed.left.left.val);
    }

    @Test
    public void testTrimBST4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 0, 2});
        TreeNode trimmed = target.trimBST(root, 1, 1);
        assertNull(trimmed.left);
        assertNull(trimmed.right);
    }

    @Test
    public void testTrimBST5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 0, 2});
        TreeNode trimmed = target.trimBST(root, 3, 4);
        assertNull(trimmed);
    }

} 
