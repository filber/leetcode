package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _160_IntersectionOfTwoLinkedListsTest {

    _160_IntersectionOfTwoLinkedLists target = null;

    @Before
    public void before() throws Exception {
        target = new _160_IntersectionOfTwoLinkedLists();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGetIntersectionNode1() throws Exception {
        ListNode node4 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        node4.next = node1;
        ListNode node8 = new ListNode(8);
        node1.next = node8;
        ListNode node4_2 = new ListNode(4);
        node8.next = node4_2;
        ListNode node5 = new ListNode(5);
        node4_2.next = node5;
        ListNode headA = node4;

        ListNode node5_2 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node5_2.next = node6;
        ListNode node1_1 = new ListNode(1);
        node6.next = node1_1;
        node1_1.next = node8;
        ListNode headB = node5_2;
        ListNode intersection = target.getIntersectionNode(headA, headB);
        assertEquals(node8, intersection);
    }

    @Test
    public void testGetIntersectionNode2() throws Exception {
        ListNode headA = new ListNode(new int[]{2, 6, 4});
        ListNode headB = new ListNode(new int[]{1, 5});
        ListNode intersection = target.getIntersectionNode(headA, headB);
        assertNull(intersection);
    }
}
