package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _814_BinaryTreePruningTest {

    _814_BinaryTreePruning target;

    @Before
    public void before() throws Exception {
        target = new _814_BinaryTreePruning();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPruneTree1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, null, 0, null, null, 0, 1});
        TreeNode pruned = target.pruneTree(root);
        assertArrayEquals(new Integer[]{1, 0, 1}, pruned.toArray());
    }

    @Test
    public void testPruneTree2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 0, 1, 0, 0, 0, 1});
        TreeNode pruned = target.pruneTree(root);
        assertArrayEquals(new Integer[]{1, 1, 1}, pruned.toArray());
    }

    @Test
    public void testPruneTree3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 1, 0, 1, 1, 0, 1, 0});
        TreeNode pruned = target.pruneTree(root);
        assertArrayEquals(new Integer[]{1, 1, 0, 1, 1, 1}, pruned.toArray());
    }
}
