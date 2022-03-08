package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _141_LinkedListCycleTest {

    _141_LinkedListCycle target = null;

    @Before
    public void before() throws Exception {
        target = new _141_LinkedListCycle();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testHasCycle1() throws Exception {
        ListNode h1_1 = new ListNode(3);
        ListNode h1_2 = new ListNode(2);
        h1_1.next = h1_2;
        ListNode h1_3 = new ListNode(0);
        h1_2.next = h1_3;
        ListNode h1_4 = new ListNode(-4, h1_2);
        h1_3.next = h1_4;

        boolean hasCycle = target.hasCycle(h1_1);
        assertTrue(hasCycle);
    }

    @Test
    public void testHasCycle2() throws Exception {
        boolean hasCycle = target.hasCycle(new ListNode(new int[]{1, 2}));
        assertFalse(hasCycle);
    }

    @Test
    public void testHasCycle3() throws Exception {
        boolean hasCycle = target.hasCycle(new ListNode(new int[]{1}));
        assertFalse(hasCycle);
    }

    @Test
    public void testHasCycle4() throws Exception {
        ListNode h2_1 = new ListNode(1);
        ListNode h2_2 = new ListNode(2);
        h2_1.next = h2_2;
        h2_2.next = h2_1;
        boolean hasCycle = target.hasCycle(h2_1);
        assertTrue(hasCycle);
    }

    @Test
    public void testHasCycle5() throws Exception {
        ListNode h5_1 = new ListNode(1);
        h5_1.next = h5_1;

        boolean hasCycle = target.hasCycle(h5_1);
        assertTrue(hasCycle);
    }

    @Test
    public void testHasCycle6() throws Exception {
        boolean hasCycle = target.hasCycle(null);
        assertFalse(hasCycle);
    }
}
