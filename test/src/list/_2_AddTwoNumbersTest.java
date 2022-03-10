package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2_AddTwoNumbersTest {

    _2_AddTwoNumbers target = null;

    @Before
    public void before() throws Exception {
        target = new _2_AddTwoNumbers();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAddTwoNumbers1() throws Exception {
        ListNode sum = target.addTwoNumbers(
                new ListNode(new int[]{2, 4, 3}),
                new ListNode(new int[]{5, 6, 4}));
        assertArrayEquals(new int[]{7, 0, 8}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers2() throws Exception {
        ListNode sum = target.addTwoNumbers(
                new ListNode(new int[]{0}),
                new ListNode(new int[]{0}));
        assertArrayEquals(new int[]{0}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers3() throws Exception {
        ListNode sum = target.addTwoNumbers(
                new ListNode(new int[]{9, 9, 9, 9, 9, 9, 9}),
                new ListNode(new int[]{9, 9, 9, 9}));
        assertArrayEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers4() throws Exception {
        ListNode sum = target.addTwoNumbers(
                new ListNode(new int[]{9, 9, 9, 9}),
                new ListNode(new int[]{9, 9, 9, 9, 9, 9, 9}));
        assertArrayEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers5() throws Exception {
        ListNode sum = target.addTwoNumbers(
                new ListNode(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                new ListNode(new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, sum.toArray());
    }

    @Test
    public void testAddTwoNumbers6() throws Exception {
        ListNode sum = target.addTwoNumbers(
                new ListNode(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                new ListNode(new int[]{0, 9, 8, 7, 6, 5}));
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 1, 7, 7, 8, 9}, sum.toArray());
    }

} 
