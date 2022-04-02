package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1216_ValidPalindromeIIITest {

    _1216_ValidPalindromeIII target = null;

    @Before
    public void before() throws Exception {
        target = new _1216_ValidPalindromeIII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testValidPalindrome1() throws Exception {
        boolean valid = target.validPalindrome("abcdeca", 2);
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome2() throws Exception {
        boolean valid = target.validPalindrome("abba", 0);
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome3() throws Exception {
        boolean valid = target.validPalindrome("abcba", 0);
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome4() throws Exception {
        boolean valid = target.validPalindrome("abcbac", 1);
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome5() throws Exception {
        boolean valid = target.validPalindrome("abcdef", 5);
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome6() throws Exception {
        boolean valid = target.validPalindrome("abcdef", 4);
        assertFalse(valid);
    }
} 
