package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _102_BinaryTreeLevelOrderTraversalTest {

    _102_BinaryTreeLevelOrderTraversal target = null;

    @Before
    public void before() throws Exception {
        target = new _102_BinaryTreeLevelOrderTraversal();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLevelOrder1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> list = target.levelOrder(root);
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[]{3}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{9, 20}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{15, 7}, list.get(2).toArray(new Integer[0]));
    }

    @Test
    public void testLevelOrder2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        List<List<Integer>> list = target.levelOrder(root);
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[]{1}, list.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testLevelOrder3() throws Exception {
        List<List<Integer>> list = target.levelOrder(null);
        assertEquals(0, list.size());
    }

} 
