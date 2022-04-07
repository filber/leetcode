package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _103_BinaryTreeZigzagLevelOrderTraversalTest {

    _103_BinaryTreeZigzagLevelOrderTraversal target = null;

    @Before
    public void before() throws Exception {
        target = new _103_BinaryTreeZigzagLevelOrderTraversal();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testZigzagLevelOrder1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, 14, null, 15, 7});
        List<List<Integer>> list = target.zigzagLevelOrder(root);
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[]{3}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{20, 9}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{14,15, 7}, list.get(2).toArray(new Integer[0]));
    }

    @Test
    public void testZigzagLevelOrder2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        List<List<Integer>> list = target.zigzagLevelOrder(root);
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[]{1}, list.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testZigzagLevelOrder3() throws Exception {
        List<List<Integer>> list = target.zigzagLevelOrder(null);
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[]{1}, list.get(0).toArray(new Integer[0]));
    }
}
