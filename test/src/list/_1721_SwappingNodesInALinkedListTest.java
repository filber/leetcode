package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1721_SwappingNodesInALinkedListTest {

    _1721_SwappingNodesInALinkedList target = null;

    @Before
    public void before() throws Exception {
        target = new _1721_SwappingNodesInALinkedList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSwapNodes1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        head = target.swapNodes(head, 2);
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, head.toArray());
    }

    @Test
    public void testSwapNodes2() throws Exception {
        ListNode head = new ListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5});
        head = target.swapNodes(head, 5);
        assertArrayEquals(new int[]{7, 9, 6, 6, 8, 7, 3, 0, 9, 5}, head.toArray());
    }

    @Test
    public void testSwapNodes3() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        head = target.swapNodes(head, 5);
        assertArrayEquals(new int[]{5, 2, 3, 4, 1}, head.toArray());
    }

    @Test
    public void testSwapNodes4() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        head = target.swapNodes(head, 1);
        assertArrayEquals(new int[]{5, 2, 3, 4, 1}, head.toArray());
    }

    @Test
    public void testSwapNodes5() throws Exception {
        ListNode head = new ListNode(new int[]{1});
        head = target.swapNodes(head, 1);
        assertArrayEquals(new int[]{1}, head.toArray());
    }
}
