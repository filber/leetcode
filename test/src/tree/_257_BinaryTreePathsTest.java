package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _257_BinaryTreePathsTest {

    _257_BinaryTreePaths target = null;

    @Before
    public void before() throws Exception {
        target = new _257_BinaryTreePaths();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testBinaryTreePaths1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 3, null, 5});
        List<String> paths = target.binaryTreePaths(root);
        assertEquals(2, paths.size());
        assertEquals("1->2->5", paths.get(0));
        assertEquals("1->3", paths.get(1));
    }

    @Test
    public void testBinaryTreePaths2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        List<String> paths = target.binaryTreePaths(root);
        assertEquals(1, paths.size());
        assertEquals("1", paths.get(0));
    }
}
