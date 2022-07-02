package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _19_RemoveNthNodeFromEndOfListTest {

    _19_RemoveNthNodeFromEndOfList target = null;

    @Before
    public void before() throws Exception {
        target = new _19_RemoveNthNodeFromEndOfList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRemoveNthFromEnd1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        ListNode rst = target.removeNthFromEnd(head, n);
        assertArrayEquals(new int[]{1, 2, 3, 5}, rst.toArray());
    }

    @Test
    public void testRemoveNthFromEnd2() throws Exception {
        ListNode head = new ListNode(new int[]{1});
        int n = 1;
        ListNode rst = target.removeNthFromEnd(head, n);
        assertNull(rst);
    }

    @Test
    public void testRemoveNthFromEnd3() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2});
        int n = 1;
        ListNode rst = target.removeNthFromEnd(head, n);
        assertArrayEquals(new int[]{1}, rst.toArray());
    }
}
