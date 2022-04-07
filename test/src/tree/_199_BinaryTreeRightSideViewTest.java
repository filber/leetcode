package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _199_BinaryTreeRightSideViewTest {

    _199_BinaryTreeRightSideView target = null;

    @Before
    public void before() throws Exception {
        target = new _199_BinaryTreeRightSideView();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRightSideView1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3, null, 5, null, 4});
        List<Integer> list = target.rightSideView(root);
        assertArrayEquals(new Integer[]{1, 3, 4}, list.toArray(new Integer[0]));
    }

    @Test
    public void testRightSideView2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, null, 3});
        List<Integer> list = target.rightSideView(root);
        assertArrayEquals(new Integer[]{1, 3}, list.toArray(new Integer[0]));
    }

    @Test
    public void testRightSideView3() throws Exception {
        List<Integer> list = target.rightSideView(null);
        assertTrue(list.isEmpty());
    }
}
