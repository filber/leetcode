package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1302_DeepestLeavesSumTest {

    _1302_DeepestLeavesSum target = null;

    @Before
    public void before() throws Exception {
        target = new _1302_DeepestLeavesSum();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testDeepestLeavesSum1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8});
        int sum = target.deepestLeavesSum(root);
        assertEquals(15, sum);
    }

    @Test
    public void testDeepestLeavesSum2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        int sum = target.deepestLeavesSum(root);
        assertEquals(19, sum);
    }

    @Test
    public void testDeepestLeavesSum3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        int sum = target.deepestLeavesSum(root);
        assertEquals(1, sum);
    }

    @Test
    public void testDeepestLeavesSum4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2});
        int sum = target.deepestLeavesSum(root);
        assertEquals(2, sum);
    }

    @Test
    public void testDeepestLeavesSum5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, null, 2});
        int sum = target.deepestLeavesSum(root);
        assertEquals(2, sum);
    }
}
