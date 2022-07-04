package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _328_OddEvenLinkedListTest {

    _328_OddEvenLinkedList target = null;

    @Before
    public void before() throws Exception {
        target = new _328_OddEvenLinkedList();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testOddEvenList1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode rst = target.oddEvenList(head);
        assertArrayEquals(new int[]{1, 3, 5, 2, 4}, rst.toArray());
    }

    @Test
    public void testOddEvenList2() throws Exception {
        ListNode head = new ListNode(new int[]{2, 1, 3, 5, 6, 4, 7});
        ListNode rst = target.oddEvenList(head);
        assertArrayEquals(new int[]{2, 3, 6, 7, 1, 5, 4}, rst.toArray());
    }

    @Test
    public void testOddEvenList3() throws Exception {
        ListNode rst = target.oddEvenList(null);
        assertNull(rst);
    }

    @Test
    public void testOddEvenList4() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2});
        ListNode rst = target.oddEvenList(head);
        assertArrayEquals(new int[]{1, 2}, rst.toArray());
    }

    @Test
    public void testOddEvenList5() throws Exception {
        ListNode head = new ListNode(new int[]{1});
        ListNode rst = target.oddEvenList(head);
        assertArrayEquals(new int[]{1}, rst.toArray());
    }
}
