package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _114_FlattenBinaryTreeToLinkedListTest {

    _114_FlattenBinaryTreeToLinkedList target = null;

    @Before
    public void before() throws Exception {
        target = new _114_FlattenBinaryTreeToLinkedList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFlatten1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6});
        target.flatten(root);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, root.toArray());
    }

} 
