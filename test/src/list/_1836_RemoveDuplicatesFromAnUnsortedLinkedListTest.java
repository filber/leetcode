package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1836_RemoveDuplicatesFromAnUnsortedLinkedListTest {

    _1836_RemoveDuplicatesFromAnUnsortedLinkedList target = null;

    @Before
    public void before() throws Exception {
        target = new _1836_RemoveDuplicatesFromAnUnsortedLinkedList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDeleteDuplicates1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 2});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1, 3}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates2() throws Exception {
        ListNode head = new ListNode(new int[]{2, 1, 1, 2});
        ListNode ans = target.deleteDuplicates(head);
        assertNull(ans);
    }

    @Test
    public void testDeleteDuplicates3() throws Exception {
        ListNode head = new ListNode(new int[]{3, 2, 2, 1, 3, 2, 4});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{1, 4}, ans.toArray());
    }

    @Test
    public void testDeleteDuplicates4() throws Exception {
        ListNode head = new ListNode(new int[]{12, 11, 12, 21, 41, 43, 21});
        ListNode ans = target.deleteDuplicates(head);
        assertArrayEquals(new int[]{11, 41, 43}, ans.toArray());
    }


}
