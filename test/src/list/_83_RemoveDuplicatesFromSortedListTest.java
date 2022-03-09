package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _83_RemoveDuplicatesFromSortedListTest {

    _83_RemoveDuplicatesFromSortedList target = null;

    @Before
    public void before() throws Exception {
        target = new _83_RemoveDuplicatesFromSortedList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDeleteDuplicates1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 2});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1, 2}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates2() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 2, 3, 3});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1, 2, 3}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates3() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 5});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1, 2, 3, 5}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates4() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 1});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1}, ans.toArray());
    }
}
