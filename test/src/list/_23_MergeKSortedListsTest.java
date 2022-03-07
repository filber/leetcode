package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _23_MergeKSortedListsTest {

    _23_MergeKSortedLists target = null;

    @Before
    public void before() throws Exception {
        target = new _23_MergeKSortedLists();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMergeKLists1() throws Exception {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(new int[]{1, 4, 5});
        lists[1] = new ListNode(new int[]{1, 3, 4});
        lists[2] = new ListNode(new int[]{2, 6});

        ListNode merged = target.mergeKLists(lists);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4, 5, 6}, merged.toArray());
    }

    @Test
    public void testMergeKLists2() throws Exception {
        ListNode merged = target.mergeKLists(new ListNode[0]);
        assertNull(merged);
    }

    @Test
    public void testMergeKLists3() throws Exception {
        ListNode merged = target.mergeKLists(new ListNode[1]);
        assertNull(merged);
    }
}
