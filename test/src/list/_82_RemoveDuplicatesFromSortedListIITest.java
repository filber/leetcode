package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _82_RemoveDuplicatesFromSortedListIITest {

    _82_RemoveDuplicatesFromSortedListII target = null;

    @Before
    public void before() throws Exception {
        target = new _82_RemoveDuplicatesFromSortedListII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDeleteDuplicates1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1, 2, 5}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates2() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 1, 2, 3});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{2, 3}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates3() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates8() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 1, 2, 2, 2});
        ListNode ans = target.deleteDuplicates(head);
        assertNull(ans);
    }

    @Test
    public void testDeleteDuplicates4() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 1});
        ListNode ans = target.deleteDuplicates(head);
        assertNull(ans);
    }

    @Test
    public void testDeleteDuplicates5() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 1, 2});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{2}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates6() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 2, 2});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates7() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 2, 2, 3});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{3}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates9() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1, 2, 3, 3});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{2}, ans.toArray());
    }
}
