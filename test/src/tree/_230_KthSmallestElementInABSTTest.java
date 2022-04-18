package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _230_KthSmallestElementInABSTTest {

    _230_KthSmallestElementInABST target = null;

    @Before
    public void before() throws Exception {
        target = new _230_KthSmallestElementInABST();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testKthSmallest1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 1, 4, null, 2});
        assertEquals(1, target.kthSmallest(root, 1));
        assertEquals(2, target.kthSmallest(root, 2));
        assertEquals(3, target.kthSmallest(root, 3));
        assertEquals(4, target.kthSmallest(root, 4));
    }

    @Test
    public void testKthSmallest2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        assertEquals(1, target.kthSmallest(root, 1));
        assertEquals(2, target.kthSmallest(root, 2));
        assertEquals(3, target.kthSmallest(root, 3));
        assertEquals(4, target.kthSmallest(root, 4));
        assertEquals(5, target.kthSmallest(root, 5));
        assertEquals(6, target.kthSmallest(root, 6));
    }
}