package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _86_PartitionListTest {

    _86_PartitionList target = null;

    @Before
    public void before() throws Exception {
        target = new _86_PartitionList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPartition1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;
        ListNode rst = target.partition(head, x);
        assertArrayEquals(new int[]{1, 2, 2, 4, 3, 5}, rst.toArray());
    }

    @Test
    public void testPartition2() throws Exception {
        ListNode head = new ListNode(new int[]{2, 1});
        int x = 2;
        ListNode rst = target.partition(head, x);
        assertArrayEquals(new int[]{1, 2}, rst.toArray());
    }
}
