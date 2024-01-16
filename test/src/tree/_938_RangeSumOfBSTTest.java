package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _938_RangeSumOfBSTTest {

    _938_RangeSumOfBST target;

    @Before
    public void setUp() {
        target = new _938_RangeSumOfBST();
    }

    @Test
    public void testRangeSumBST1() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{10, 5, 15, 3, 7, null, 18});
        int low = 7;
        int high = 15;
        int sum = target.rangeSumBST(root, low, high);
        assertEquals(32, sum);
    }

    @Test
    public void testRangeSumBST2() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6});
        int low = 6;
        int high = 10;
        int sum = target.rangeSumBST(root, low, high);
        assertEquals(23, sum);
    }
}