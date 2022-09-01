package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1448_CountGoodNodesInBinaryTreeTest {

    _1448_CountGoodNodesInBinaryTree target;

    @Before
    public void before() throws Exception {
        target = new _1448_CountGoodNodesInBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGoodNodes1() throws Exception {
        //    [3]
        //   /   \
        //  1    [4]
        //  /    / \
        //[3]   1  [5]
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 1, 4, 3, null, 1, 5});
        int cnt = target.goodNodes(root);
        assertEquals(4, cnt);
    }

    @Test
    public void testGoodNodes2() throws Exception {
        //   [3]
        //   /
        //  [3]
        //  / \
        //[4]  2
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 3, null, 4, 2});
        int cnt = target.goodNodes(root);
        assertEquals(3, cnt);
    }

    @Test
    public void testGoodNodes3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        int cnt = target.goodNodes(root);
        assertEquals(1, cnt);
    }
}
