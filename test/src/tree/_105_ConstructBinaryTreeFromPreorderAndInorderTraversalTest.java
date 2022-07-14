package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    _105_ConstructBinaryTreeFromPreorderAndInorderTraversal target;

    @Before
    public void before() throws Exception {
        target = new _105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testBuildTree1() throws Exception {
        //                3
        //               / \
        //              9   20
        //                 /  \
        //                15   7
        TreeNode root = target.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        assertArrayEquals(new Integer[]{3, 9, 20, 15, 7}, root.toArray());
    }

    @Test
    public void testBuildTree2() throws Exception {
        TreeNode root = target.buildTree(new int[]{-1}, new int[]{-1});
        assertArrayEquals(new Integer[]{-1}, root.toArray());
    }

    @Test
    public void testBuildTree3() throws Exception {
        //                3
        //                 \
        //                  20
        //                 /  \
        //                15   7
        TreeNode root = target.buildTree(new int[]{3, 20, 15, 7}, new int[]{3, 15, 20, 7});
        assertArrayEquals(new Integer[]{3, 20, 15, 7}, root.toArray());
    }

    @Test
    public void testBuildTree4() throws Exception {
        //                3
        //               /
        //              9
        //             /  \
        //            20   7
        TreeNode root = target.buildTree(new int[]{3, 9, 20, 7}, new int[]{20, 9, 7, 3});
        assertArrayEquals(new Integer[]{3, 9, 20, 7}, root.toArray());
    }
}
