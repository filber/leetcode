package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _129_SumRootToLeafNumbersTest {

    _129_SumRootToLeafNumbers target = null;

    @Before
    public void before() throws Exception {
        target = new _129_SumRootToLeafNumbers();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSumNumbers1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        int sum = target.sumNumbers(root);
        assertEquals(1, sum);
    }

    @Test
    public void testSumNumbers2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3});
        int sum = target.sumNumbers(root);
        assertEquals(25, sum);
    }

    @Test
    public void testSumNumbers3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{4, 9, 0, 5, 1});
        int sum = target.sumNumbers(root);
        assertEquals(1026, sum);
    }
}
