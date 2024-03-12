package list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1171_RemoveZeroSumConsecutiveNodesFromLinkedListTest {

    _1171_RemoveZeroSumConsecutiveNodesFromLinkedList target;

    @Before
    public void setUp() throws Exception {
        target = new _1171_RemoveZeroSumConsecutiveNodesFromLinkedList();
    }

    @Test
    public void testRemoveZeroSumSublists1() {
        ListNode head = new ListNode(new int[]{1, 2, -3, 3, 1});
        ListNode after = target.removeZeroSumSublists(head);
        int[] actual = after.toArray();
        int[] expect = {3, 1};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void testRemoveZeroSumSublists2() {
        ListNode head = new ListNode(new int[]{1, 2, 3, -3, 4});
        ListNode after = target.removeZeroSumSublists(head);
        int[] actual = after.toArray();
        int[] expect = {1, 2, 4};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void testRemoveZeroSumSublists3() {
        ListNode head = new ListNode(new int[]{1, 2, 3, -3, -2});
        ListNode after = target.removeZeroSumSublists(head);
        int[] actual = after.toArray();
        int[] expect = {1};
        assertArrayEquals(expect, actual);
    }
}