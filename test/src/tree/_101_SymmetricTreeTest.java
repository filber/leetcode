package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _101_SymmetricTreeTest {

    _101_SymmetricTree target = null;

    @Before
    public void before() throws Exception {
        target = new _101_SymmetricTree();
    }

    @After
    public void after() throws Exception {
    }


    //       1
    //      / \
    //     2   2
    //    / \ / \
    //   3  4 4  3
    @Test
    public void testIsSymmetric1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        boolean isSymmetric = target.isSymmetric(root);
        assertTrue(isSymmetric);
    }

    @Test
    public void testIsSymmetric2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3});
        boolean isSymmetric = target.isSymmetric(root);
        assertFalse(isSymmetric);
    }

    @Test
    public void testIsSymmetric3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 2, null, 3, 3});
        boolean isSymmetric = target.isSymmetric(root);
        assertTrue(isSymmetric);
    }

    @Test
    public void testIsSymmetric4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 2, null, 3, 4});
        boolean isSymmetric = target.isSymmetric(root);
        assertFalse(isSymmetric);
    }

    @Test
    public void testIsSymmetric5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        boolean isSymmetric = target.isSymmetric(root);
        assertTrue(isSymmetric);
    }

    @Test
    public void testIsSymmetric6() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        boolean isSymmetric = target.isSymmetric(root);
        assertTrue(isSymmetric);
    }
}
