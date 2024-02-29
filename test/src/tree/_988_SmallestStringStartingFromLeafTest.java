package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _988_SmallestStringStartingFromLeafTest {

    _988_SmallestStringStartingFromLeaf target;

    @Before
    public void setUp() throws Exception {
        target = new _988_SmallestStringStartingFromLeaf();
    }

    @Test
    public void testSmallestFromLeaf1() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{0, 1, 2, 3, 4, 3, 4});
        String result = target.smallestFromLeaf(root);
        assertEquals("dba", result);
    }

    @Test
    public void testSmallestFromLeaf2() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{25, 1, 3, 1, 3, 0, 2});
        String result = target.smallestFromLeaf(root);
        assertEquals("adz", result);
    }
}