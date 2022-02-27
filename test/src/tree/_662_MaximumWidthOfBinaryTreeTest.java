package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _662_MaximumWidthOfBinaryTreeTest {

    _662_MaximumWidthOfBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _662_MaximumWidthOfBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testWidthOfBinaryTree1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 3, 2, 5, 3, null, 9});
        int width = target.widthOfBinaryTree(root);
        assertEquals(4, width);
    }

    @Test
    public void testWidthOfBinaryTree2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 3, null, 5, 3});
        int width = target.widthOfBinaryTree(root);
        assertEquals(2, width);
    }

    @Test
    public void testWidthOfBinaryTree3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 3, 2, 5});
        int width = target.widthOfBinaryTree(root);
        assertEquals(2, width);
    }

    @Test
    public void testWidthOfBinaryTree4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 3, 2, 5, null, 4});
        int width = target.widthOfBinaryTree(root);
        assertEquals(3, width);
    }

    @Test
    public void testWidthOfBinaryTree5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 3, 2, 5, null, null, 4});
        int width = target.widthOfBinaryTree(root);
        assertEquals(4, width);
    }

} 
