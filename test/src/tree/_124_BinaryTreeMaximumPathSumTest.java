package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _124_BinaryTreeMaximumPathSumTest {

    _124_BinaryTreeMaximumPathSum target = null;

    @Before
    public void before() throws Exception {
        target = new _124_BinaryTreeMaximumPathSum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxPathSum1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3});
        int sum = target.maxPathSum(root);
        assertEquals(6, sum);
    }

    @Test
    public void testMaxPathSum2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{-10, 9, 20, null, null, 15, 7});
        int sum = target.maxPathSum(root);
        assertEquals(42, sum);
    }

    @Test
    public void testMaxPathSum3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{0});
        int sum = target.maxPathSum(root);
        assertEquals(0, sum);
    }

    @Test
    public void testMaxPathSum4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1});
        int sum = target.maxPathSum(root);
        assertEquals(48, sum);
    }
}
