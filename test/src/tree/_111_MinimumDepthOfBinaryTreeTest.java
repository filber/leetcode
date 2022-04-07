package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _111_MinimumDepthOfBinaryTreeTest {

    _111_MinimumDepthOfBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _111_MinimumDepthOfBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinDepth1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        int depth = target.minDepth(root);
        assertEquals(2, depth);
    }

    @Test
    public void testMinDepth2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{2,
                null, 3,
                null, null, null, 4,
                null, null, null, null, null, null, null, 5,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 6});
        int depth = target.minDepth(root);
        assertEquals(5, depth);
    }
}
