package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_ReverseAlternateKNodesInASinglyLinkedListTest {

    _EX_ReverseAlternateKNodesInASinglyLinkedList target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_ReverseAlternateKNodesInASinglyLinkedList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testKAltReverse1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        int k = 3;
        ListNode reversed = target.kAltReverse(head, k);
        assertArrayEquals(new int[]{3, 2, 1, 4, 5, 6, 9, 8, 7}, reversed.toArray());
    }

    @Test
    public void testKAltReverse2() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 3;
        ListNode reversed = target.kAltReverse(head, k);
        assertArrayEquals(new int[]{3, 2, 1, 4, 5, 6, 9, 8, 7, 10}, reversed.toArray());
    }

    @Test
    public void testKAltReverse3() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        int k = 3;
        ListNode reversed = target.kAltReverse(head, k);
        assertArrayEquals(new int[]{3, 2, 1, 4, 5, 6, 9, 8, 7, 10, 11}, reversed.toArray());
    }

    @Test
    public void testKAltReverse4() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        int k = 3;
        ListNode reversed = target.kAltReverse(head, k);
        assertArrayEquals(new int[]{3, 2, 1, 4, 5, 6, 9, 8, 7, 10, 11, 12}, reversed.toArray());
    }

    @Test
    public void testKAltReverse5() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        int k = 0;
        ListNode reversed = target.kAltReverse(head, k);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, reversed.toArray());
    }

    @Test
    public void testKAltReverse6() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        int k = 1;
        ListNode reversed = target.kAltReverse(head, k);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, reversed.toArray());
    }
}
