package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _501_FindModeInBinarySearchTreeTest {

    _501_FindModeInBinarySearchTree target = null;

    @Before
    public void before() throws Exception {
        target = new _501_FindModeInBinarySearchTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMode1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, null, 2, null, null, 2});
        int[] modes = target.findMode(root);
        assertArrayEquals(new int[]{2}, modes);
    }

    @Test
    public void testFindMode2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 1, 2, null, null, 2});
        int[] modes = target.findMode(root);
        assertArrayEquals(new int[]{1, 2}, modes);
    }

    @Test
    public void testFindMode3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{0});
        int[] modes = target.findMode(root);
        assertArrayEquals(new int[]{0}, modes);
    }

    @Test
    public void testFindMode4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 2, 4, 2, 2, 4, 4, null, null, null, 3, 3, null, null, 4});
        int[] modes = target.findMode(root);
        assertArrayEquals(new int[]{4}, modes);
    }

    @Test
    public void testFindMode5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 2, 4, 2, 2, 4, 4, null, null, null, 3, 3, null, null, 5});
        int[] modes = target.findMode(root);
        assertArrayEquals(new int[]{2, 3, 4}, modes);
    }
}
