package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _437_PathSumIIITest {

    _437_PathSumIII target = null;

    @Before
    public void before() throws Exception {
        target = new _437_PathSumIII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPathSum1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        int cnt = target.pathSum(root, 8);
        assertEquals(3, cnt);
    }

    @Test
    public void testPathSum2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        int cnt = target.pathSum(root, 22);
        assertEquals(3, cnt);
    }

    @Test
    public void testPathSum3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        int cnt = target.pathSum(root, 26);
        assertEquals(1, cnt);
    }

    @Test
    public void testPathSum4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        int cnt = target.pathSum(root, 27);
        assertEquals(1, cnt);
    }

    @Test
    public void testPathSum5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        int cnt = target.pathSum(root, 28);
        assertEquals(0, cnt);
    }
}
