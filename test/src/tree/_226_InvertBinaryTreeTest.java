package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _226_InvertBinaryTreeTest {

    _226_InvertBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _226_InvertBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testInvertTree1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode inverted = target.invertTree(root);
        assertArrayEquals(new Integer[]{4, 7, 2, 9, 6, 3, 1}, inverted.toArray());
    }

    @Test
    public void testInvertTree2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{2, 1, 3});
        TreeNode inverted = target.invertTree(root);
        assertArrayEquals(new Integer[]{2, 3, 1}, inverted.toArray());
    }

    @Test
    public void testInvertTree3() throws Exception {
        TreeNode inverted = target.invertTree(null);
        assertNull(inverted);
    }
}
