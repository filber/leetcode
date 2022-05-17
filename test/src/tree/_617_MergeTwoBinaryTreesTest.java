package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _617_MergeTwoBinaryTreesTest {

    _617_MergeTwoBinaryTrees target = null;

    @Before
    public void before() throws Exception {
        target = new _617_MergeTwoBinaryTrees();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMergeTrees1() throws Exception {
        TreeNode left = TreeNode.createTreeNode(new Integer[]{1, 3, 2, 5});
        TreeNode right = TreeNode.createTreeNode(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode merged = target.mergeTrees(left, right);
        assertArrayEquals(new Integer[]{3, 4, 5, 5, 4, 7}, merged.toArray());
    }

    @Test
    public void testMergeTrees2() throws Exception {
        TreeNode left = TreeNode.createTreeNode(new Integer[]{1});
        TreeNode right = TreeNode.createTreeNode(new Integer[]{1, 2});
        TreeNode merged = target.mergeTrees(left, right);
        assertArrayEquals(new Integer[]{2, 2}, merged.toArray());
    }

    @Test
    public void testMergeTrees3() throws Exception {
        TreeNode right = TreeNode.createTreeNode(new Integer[]{1, 2});
        TreeNode merged = target.mergeTrees(null, right);
        assertArrayEquals(new Integer[]{1, 2}, merged.toArray());
    }
}
