package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _234_PalindromeLinkedListTest {

    _234_PalindromeLinkedList target = null;

    @Before
    public void before() throws Exception {
        target = new _234_PalindromeLinkedList();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsPalindrome1() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 2, 1});
        boolean res = target.isPalindrome(head);
        assertTrue(res);
    }

    @Test
    public void testIsPalindrome2() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 1});
        boolean res = target.isPalindrome(head);
        assertTrue(res);
    }

    @Test
    public void testIsPalindrome3() throws Exception {
        ListNode head = new ListNode(new int[]{1});
        boolean res = target.isPalindrome(head);
        assertTrue(res);
    }

    @Test
    public void testIsPalindrome4() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2});
        boolean res = target.isPalindrome(head);
        assertFalse(res);
    }

    @Test
    public void testIsPalindrome5() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 2, 3});
        boolean res = target.isPalindrome(head);
        assertFalse(res);
    }

    @Test
    public void testIsPalindrome6() throws Exception {
        ListNode head = new ListNode(new int[]{1, 1});
        boolean res = target.isPalindrome(head);
        assertTrue(res);
    }

    @Test
    public void testIsPalindrome7() throws Exception {
        ListNode head = new ListNode(new int[]{1, 2, 3, 2, 1});
        boolean res = target.isPalindrome(head);
        assertTrue(res);
    }
} 
