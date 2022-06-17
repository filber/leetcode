package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _968_BinaryTreeCamerasTest {

    _968_BinaryTreeCameras target = null;

    @Before
    public void before() throws Exception {
        target = new _968_BinaryTreeCameras();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinCameraCover1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{0, 0, null, 0, 0});
        int count = target.minCameraCover(root);
        assertEquals(1, count);
    }

    @Test
    public void testMinCameraCover2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                0,
                0, null,
                0, null, null, null,
                0});
        int count = target.minCameraCover(root);
        assertEquals(2, count);
    }

    @Test
    public void testMinCameraCover3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{0});
        int count = target.minCameraCover(root);
        assertEquals(1, count);
    }

    @Test
    public void testMinCameraCover4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{0, 0});
        int count = target.minCameraCover(root);
        assertEquals(1, count);
    }
}
