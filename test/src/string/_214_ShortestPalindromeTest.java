package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _214_ShortestPalindromeTest {

    _214_ShortestPalindrome target = null;

    @Before
    public void before() throws Exception {
        target = new _214_ShortestPalindrome();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testShortestPalindrome1() throws Exception {
        String palindrome = target.shortestPalindrome("aacecaaa");
        assertEquals("aaacecaaa", palindrome);
    }

    @Test
    public void testShortestPalindrome2() throws Exception {
        String palindrome = target.shortestPalindrome("abcd");
        assertEquals("dcbabcd", palindrome);
    }

    @Test
    public void testShortestPalindrome3() throws Exception {
        String palindrome = target.shortestPalindrome("abaa");
        assertEquals("aabaa", palindrome);
    }
}
