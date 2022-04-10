package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _543_DiameterOfBinaryTreeTest {

    _543_DiameterOfBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _543_DiameterOfBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDiameterOfBinaryTree1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3, 4, 5});
        int diameter = target.diameterOfBinaryTree(root);
        assertEquals(3, diameter);
    }

    @Test
    public void testDiameterOfBinaryTree2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2});
        int diameter = target.diameterOfBinaryTree(root);
        assertEquals(1, diameter);
    }

    @Test
    public void testDiameterOfBinaryTree3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        int diameter = target.diameterOfBinaryTree(root);
        assertEquals(0, diameter);
    }
}
