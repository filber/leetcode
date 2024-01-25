package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1457_PseudoPalindromicPathsInABinaryTreeTest {

    _1457_PseudoPalindromicPathsInABinaryTree target;

    @Before
    public void setUp() throws Exception {
        target = new _1457_PseudoPalindromicPathsInABinaryTree();
    }

    @Test
    public void testPseudoPalindromicPaths1() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{2, 3, 1, 3, 1, null, 1});
        int paths = target.pseudoPalindromicPaths(root);
        assertEquals(2, paths);
    }

    @Test
    public void testPseudoPalindromicPaths2() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1});
        int paths = target.pseudoPalindromicPaths(root);
        assertEquals(1, paths);
    }

    @Test
    public void testPseudoPalindromicPaths3() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{9});
        int paths = target.pseudoPalindromicPaths(root);
        assertEquals(1, paths);
    }
}