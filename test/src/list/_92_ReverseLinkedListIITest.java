package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _92_ReverseLinkedListIITest {

    _92_ReverseLinkedListII target = null;

    @Before
    public void before() throws Exception {
        target = new _92_ReverseLinkedListII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testReverseBetween1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int left = 2;
        int right = 4;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, reversed.toArray());
    }

    @Test
    public void testReverseBetween2() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int left = 1;
        int right = 4;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{4, 3, 2, 1, 5}, reversed.toArray());
    }

    @Test
    public void testReverseBetween3() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int left = 2;
        int right = 5;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{1, 5, 4, 3, 2}, reversed.toArray());
    }

    @Test
    public void testReverseBetween4() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int left = 1;
        int right = 5;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reversed.toArray());
    }

    @Test
    public void testReverseBetween5() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int left = 2;
        int right = 3;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{1, 3, 2, 4, 5}, reversed.toArray());
    }

    @Test
    public void testReverseBetween6() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int left = 2;
        int right = 2;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, reversed.toArray());
    }

    @Test
    public void testReverseBetween7() throws Exception {
        ListNode head = new ListNode(new int[]{1});
        int left = 1;
        int right = 1;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{1}, reversed.toArray());
    }

    @Test
    public void testReverseBetween8() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2});
        int left = 1;
        int right = 2;
        ListNode reversed = target.reverseBetween(head, left, right);
        assertArrayEquals(new int[]{2, 1}, reversed.toArray());
    }
} 
