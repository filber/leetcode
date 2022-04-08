package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _112_PathSumTest {

    _112_PathSum target = null;

    @Before
    public void before() throws Exception {
        target = new _112_PathSum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testHasPathSum1() throws Exception {
        boolean has = target.hasPathSum(null, 0);
        assertFalse(has);
    }

    @Test
    public void testHasPathSum2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3});
        boolean has = target.hasPathSum(root, 3);
        assertTrue(has);
    }

    @Test
    public void testHasPathSum3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3});
        boolean has = target.hasPathSum(root, 4);
        assertTrue(has);
    }

    @Test
    public void testHasPathSum4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3});
        boolean has = target.hasPathSum(root, 5);
        assertFalse(has);
    }

    @Test
    public void testHasPathSum5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, null, 1});
        boolean has = target.hasPathSum(root, 22);
        assertTrue(has);
    }

    @Test
    public void testHasPathSum6() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, null, 1});
        boolean has = target.hasPathSum(root, 27);
        assertTrue(has);
    }

    @Test
    public void testHasPathSum7() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, null, 1});
        boolean has = target.hasPathSum(root, 26);
        assertTrue(has);
    }

    @Test
    public void testHasPathSum8() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, null, 1});
        boolean has = target.hasPathSum(root, 50);
        assertFalse(has);
    }

} 
