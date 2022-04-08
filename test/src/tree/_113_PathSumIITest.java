package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _113_PathSumIITest {

    _113_PathSumII target = null;

    @Before
    public void before() throws Exception {
        target = new _113_PathSumII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPathSum1() throws Exception {
        List<List<Integer>> list = target.pathSum(null, 0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPathSum2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2});
        List<List<Integer>> list = target.pathSum(root, 0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPathSum3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2});
        List<List<Integer>> list = target.pathSum(root, 3);
        assertArrayEquals(new Integer[]{1, 2}, list.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testPathSum4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3});
        List<List<Integer>> list = target.pathSum(root, 4);
        assertArrayEquals(new Integer[]{1, 3}, list.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testPathSum5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3});
        List<List<Integer>> list = target.pathSum(root, 5);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPathSum6() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, 5, 1});
        List<List<Integer>> list = target.pathSum(root, 22);
        assertArrayEquals(new Integer[]{5, 4, 11, 2}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{5, 8, 4, 5}, list.get(1).toArray(new Integer[0]));
    }
}
