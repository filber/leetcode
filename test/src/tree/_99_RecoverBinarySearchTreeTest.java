package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _99_RecoverBinarySearchTreeTest {

    _99_RecoverBinarySearchTree target = null;

    @Before
    public void before() throws Exception {
        target = new _99_RecoverBinarySearchTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRecoverTree1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 3, null, null, 2});
        target.recoverTree(root);
        assertArrayEquals(new Integer[]{3, 1, 2}, root.toArray());
    }

    @Test
    public void testRecoverTree2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 1, 4, null, null, 2});
        target.recoverTree(root);
        assertArrayEquals(new Integer[]{2, 1, 4, 3}, root.toArray());
    }

    @Test
    public void testRecoverTree3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                7,
                2, 6,
                1, 3, 5, 4
        });
        target.recoverTree(root);
        assertArrayEquals(new Integer[]{
                4,
                2, 6,
                1, 3, 5, 7
        }, root.toArray());
    }

    @Test
    public void testRecoverTree4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 1, 2});
        target.recoverTree(root);
        assertArrayEquals(new Integer[]{2, 1, 3}, root.toArray());
    }
}