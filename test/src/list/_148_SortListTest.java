package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _148_SortListTest {

    _148_SortList target = null;

    @Before
    public void before() throws Exception {
        target = new _148_SortList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSortList1() throws Exception {
        ListNode head = new ListNode(new int[]{4, 2, 1, 3});
        ListNode sorted = target.sortList(head);
        assertArrayEquals(new int[]{1, 2, 3, 4}, sorted.toArray());
    }

    @Test
    public void testSortList2() throws Exception {
        ListNode head = new ListNode(new int[]{-1, 5, 3, 4, 0});
        ListNode sorted = target.sortList(head);
        assertArrayEquals(new int[]{-1, 0, 3, 4, 5}, sorted.toArray());
    }

    @Test
    public void testSortList3() throws Exception {
        ListNode sorted = target.sortList(null);
        assertNull(sorted);
    }

    @Test
    public void testSortList4() throws Exception {
        ListNode head = new ListNode(new int[]{1});
        ListNode sorted = target.sortList(head);
        assertArrayEquals(new int[]{1}, sorted.toArray());
    }

    @Test
    public void testSortList5() throws Exception {
        ListNode head = new ListNode(new int[]{4, 19, 14, 5, -3, 1, 8, 5, 11, 15});
        ListNode sorted = target.sortList(head);
        assertArrayEquals(new int[]{-3, 1, 4, 5, 5, 8, 11, 14, 15, 19}, sorted.toArray());
    }
}
