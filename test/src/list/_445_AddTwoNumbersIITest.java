package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _445_AddTwoNumbersIITest {

    _445_AddTwoNumbersII target = null;

    @Before
    public void before() throws Exception {
        target = new _445_AddTwoNumbersII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAddTwoNumbers1() throws Exception {
        ListNode sum = target.addTwoNumbers(new ListNode(new int[]{7, 2, 4, 3}), new ListNode(new int[]{5, 6, 4}));
        assertArrayEquals(new int[]{7, 8, 0, 7}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers2() throws Exception {
        ListNode sum = target.addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4}));
        assertArrayEquals(new int[]{8, 0, 7}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers3() throws Exception {
        ListNode sum = target.addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{0}));
        assertArrayEquals(new int[]{2, 4, 3}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers4() throws Exception {
        ListNode sum = target.addTwoNumbers(new ListNode(new int[]{0}), new ListNode(new int[]{2, 4, 3}));
        assertArrayEquals(new int[]{2, 4, 3}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers5() throws Exception {
        ListNode sum = target.addTwoNumbers(new ListNode(new int[]{9, 9, 9, 9}), new ListNode(new int[]{9}));
        assertArrayEquals(new int[]{1, 0, 0, 0, 8}, sum.toArray());
    }
}
