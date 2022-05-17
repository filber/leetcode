package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _450_DeleteNodeInABSTTest {

    _450_DeleteNodeInABST target = null;

    @Before
    public void before() throws Exception {
        target = new _450_DeleteNodeInABST();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testDeleteNode1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode tree = target.deleteNode(root, 3);
        assertArrayEquals(new Integer[]{5, 2, 6, 4, 7}, tree.toArray());
    }

    @Test
    public void testDeleteNode2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode tree = target.deleteNode(root, 5);
        assertArrayEquals(new Integer[]{4, 3, 6, 2, 7}, tree.toArray());
    }

    @Test
    public void testDeleteNode3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode tree = target.deleteNode(root, 0);
        assertArrayEquals(new Integer[]{5, 3, 6, 2, 4, 7}, tree.toArray());
    }

    @Test
    public void testDeleteNode4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode tree = target.deleteNode(root, 7);
        assertArrayEquals(new Integer[]{5, 3, 6, 2, 4}, tree.toArray());
    }

    @Test
    public void testDeleteNode5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode tree = target.deleteNode(root, 4);
        assertArrayEquals(new Integer[]{5, 3, 6, 2, 7}, tree.toArray());
    }

    @Test
    public void testDeleteNode6() throws Exception {
        TreeNode tree = target.deleteNode(null, 4);
        assertNull(tree);
    }

    @Test
    public void testDeleteNode7() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{33, 25, 40, 11, 31, 34, 45, 10, 18, 29, 32, null, 36});
        TreeNode tree = target.deleteNode(root, 33);
        assertArrayEquals(new Integer[]{5, 3, 6, 2, 7}, tree.toArray());
    }
}
