package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._173_BinarySearchTreeIterator.BSTIterator;

import static org.junit.Assert.*;

public class _173_BinarySearchTreeIteratorTest {

    _173_BinarySearchTreeIterator target = null;

    @Before
    public void before() throws Exception {
        target = new _173_BinarySearchTreeIterator();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testBSTIterator1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator bstIterator = new BSTIterator(root);
        assertEquals(3, bstIterator.next());
        assertEquals(7, bstIterator.next());
        assertTrue(bstIterator.hasNext());
        assertEquals(9, bstIterator.next());
        assertTrue(bstIterator.hasNext());
        assertEquals(15, bstIterator.next());
        assertTrue(bstIterator.hasNext());
        assertEquals(20, bstIterator.next());
        assertFalse(bstIterator.hasNext());
    }

    @Test
    public void testBSTIterator2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1});
        BSTIterator bstIterator = new BSTIterator(root);
        assertTrue(bstIterator.hasNext());
        assertEquals(1, bstIterator.next());
        assertFalse(bstIterator.hasNext());
    }
} 
