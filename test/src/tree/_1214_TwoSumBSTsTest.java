package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1214_TwoSumBSTsTest {

    _1214_TwoSumBSTs target = null;

    @Before
    public void before() throws Exception {
        target = new _1214_TwoSumBSTs();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindTarget1() throws Exception {
        TreeNode L = TreeNode.createTreeNode(new Integer[]{2, 1, 4});
        TreeNode R = TreeNode.createTreeNode(new Integer[]{1, 0, 3});
        int k = 5;
        boolean contain = target.findTarget(L, R, k);
        assertTrue(contain);
    }

    @Test
    public void testFindTarget2() throws Exception {
        TreeNode L = TreeNode.createTreeNode(new Integer[]{0, -10, 10});
        TreeNode R = TreeNode.createTreeNode(new Integer[]{5, 1, 7, 0, 2});
        int k = 17;
        boolean contain = target.findTarget(L, R, k);
        assertTrue(contain);
    }

    @Test
    public void testFindTarget3() throws Exception {
        TreeNode L = TreeNode.createTreeNode(new Integer[]{0, -10, 10});
        TreeNode R = TreeNode.createTreeNode(new Integer[]{5, 1, 7, 0, 2});
        int k = 18;
        boolean contain = target.findTarget(L, R, k);
        assertFalse(contain);
    }
}
