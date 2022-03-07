package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _21_MergeTwoSortedListsTest {

    _21_MergeTwoSortedLists target = null;

    @Before
    public void before() throws Exception {
        target = new _21_MergeTwoSortedLists();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMergeTwoLists1() throws Exception {
        ListNode list1 = new ListNode(new int[]{1, 2, 4});
        ListNode list2 = new ListNode(new int[]{1, 3, 4});
        ListNode mergedList = target.mergeTwoLists(list1, list2);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, mergedList.toArray());
    }

    @Test
    public void testMergeTwoLists2() throws Exception {
        ListNode list1 = new ListNode(new int[]{1, 2, 3});
        ListNode list2 = new ListNode(new int[]{4, 4, 4});
        ListNode mergedList = target.mergeTwoLists(list1, list2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 4, 4}, mergedList.toArray());
    }

    @Test
    public void testMergeTwoLists3() throws Exception {
        ListNode list1 = new ListNode(new int[]{0});
        ListNode mergedList = target.mergeTwoLists(list1, null);
        assertArrayEquals(new int[]{0}, mergedList.toArray());
    }

    @Test
    public void testMergeTwoLists4() throws Exception {
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode mergedList = target.mergeTwoLists(list1, list2);
        assertNull(mergedList);
    }

    @Test
    public void testMergeTwoLists5() throws Exception {
        ListNode list2 = new ListNode(new int[]{0});
        ListNode mergedList = target.mergeTwoLists(null, list2);
        assertArrayEquals(new int[]{0}, mergedList.toArray());
    }

} 
