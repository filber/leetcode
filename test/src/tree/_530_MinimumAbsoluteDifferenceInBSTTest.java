package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _530_MinimumAbsoluteDifferenceInBSTTest {

    _530_MinimumAbsoluteDifferenceInBST target = null;

    @Before
    public void before() throws Exception {
        target = new _530_MinimumAbsoluteDifferenceInBST();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGetMinimumDifference1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{4, 2, 6, 1, 3});
        int minDiff = target.getMinimumDifference(root);
        assertEquals(1, minDiff);
    }

    @Test
    public void testGetMinimumDifference2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 0, 48, null, null, 12, 49});
        int minDiff = target.getMinimumDifference(root);
        assertEquals(1, minDiff);
    }
}
