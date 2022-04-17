package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _897_IncreasingOrderSearchTreeTest {

    _897_IncreasingOrderSearchTree target = null;

    @Before
    public void before() throws Exception {
        target = new _897_IncreasingOrderSearchTree();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIncreasingBST1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                3, 6,
                2, 4, null, 8,
                1, null, null, null, null, null, 7, 9
        });
        root = target.increasingBST(root);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, root.toArray());
    }

    @Test
    public void testIncreasingBST2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                1, 7
        });
        root = target.increasingBST(root);
        assertArrayEquals(new Integer[]{1, 5, 7}, root.toArray());
    }

    @Test
    public void testIncreasingBST3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
        });
        root = target.increasingBST(root);
        assertEquals(5, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testIncreasingBST4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                4, null,
                3, null, null, null,
                2
        });
        root = target.increasingBST(root);
        assertArrayEquals(new Integer[]{2, 3, 4, 5}, root.toArray());
    }
}
