package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _653_TwoSumIVTest {

    _653_TwoSumIV target = null;

    @Before
    public void before() throws Exception {
        target = new _653_TwoSumIV();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindTarget1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7});
        int k = 9;
        boolean contain = target.findTarget(root, k);
        assertTrue(contain);
    }

    @Test
    public void testFindTarget2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7});
        int k = 28;
        boolean contain = target.findTarget(root, k);
        assertFalse(contain);
    }
}
