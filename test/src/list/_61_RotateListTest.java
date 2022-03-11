package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _61_RotateListTest {

    _61_RotateList target = null;

    @Before
    public void before() throws Exception {
        target = new _61_RotateList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRotateRight1() throws Exception {
        ListNode head = target.rotateRight(new ListNode(new int[]{1, 2, 3, 4, 5}), 2);
        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, head.toArray());
    }

    @Test
    public void testRotateRight2() throws Exception {
        ListNode head = target.rotateRight(null, 2);
        assertNull(head);
    }

    @Test
    public void testRotateRight3() throws Exception {
        ListNode head = target.rotateRight(new ListNode(new int[]{1, 2, 3, 4, 5}), 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, head.toArray());
    }

    @Test
    public void testRotateRight4() throws Exception {
        ListNode head = target.rotateRight(new ListNode(new int[]{0, 1, 2}), 4);
        assertArrayEquals(new int[]{2, 0, 1}, head.toArray());
    }

    @Test
    public void testRotateRight5() throws Exception {
        ListNode head = target.rotateRight(new ListNode(new int[]{1}), 4);
        assertArrayEquals(new int[]{1}, head.toArray());
    }

    @Test
    public void testRotateRight6() throws Exception {
        ListNode head = target.rotateRight(new ListNode(new int[]{1, 2}), 3);
        assertArrayEquals(new int[]{2, 1}, head.toArray());
    }

    @Test
    public void testRotateRight7() throws Exception {
        ListNode head = target.rotateRight(new ListNode(new int[]{1, 2}), 4);
        assertArrayEquals(new int[]{1, 2}, head.toArray());
    }
} 
