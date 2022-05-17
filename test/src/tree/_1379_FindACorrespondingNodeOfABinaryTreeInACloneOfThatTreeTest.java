package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest {

    _1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree target = null;

    @Before
    public void before() throws Exception {
        target = new _1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGetTargetCopy1() throws Exception {
        TreeNode original = TreeNode.createTreeNode(new Integer[]{7, 4, 3, null, null, 6, 19});
        TreeNode cloned = TreeNode.createTreeNode(new Integer[]{7, 4, 3, null, null, 6, 19});
        TreeNode t = original.right;
        TreeNode rst = target.getTargetCopy(original, cloned, t);
        assertEquals(3, rst.val);
    }

    @Test
    public void testGetTargetCopy2() throws Exception {
        TreeNode original = TreeNode.createTreeNode(new Integer[]{7});
        TreeNode cloned = TreeNode.createTreeNode(new Integer[]{7});
        TreeNode t = original;
        TreeNode rst = target.getTargetCopy(original, cloned, t);
        assertEquals(7, rst.val);
    }
}
