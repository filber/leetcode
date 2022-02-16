package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _24_SwapNodesInPairsTest {

    _24_SwapNodesInPairs target = null;

    @Before
    public void before() throws Exception {
        target = new _24_SwapNodesInPairs();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSwapPairs1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        ListNode res = target.swapPairs(head);
        assertArrayEquals(new int[]{2, 1, 4, 3}, res.toArray());
    }

    @Test
    public void testSwapPairs2() throws Exception {
        ListNode res = target.swapPairs(null);
        assertNull(res);
    }

    @Test
    public void testSwapPairs3() throws Exception {
        ListNode head = new ListNode(new int[]{1});
        ListNode res = target.swapPairs(head);
        assertArrayEquals(new int[]{1}, res.toArray());
    }
}
