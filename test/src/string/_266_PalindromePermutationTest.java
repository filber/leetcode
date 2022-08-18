package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _266_PalindromePermutationTest {

    _266_PalindromePermutation target = null;

    @Before
    public void before() throws Exception {
        target = new _266_PalindromePermutation();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCanPermutePalindrome1() throws Exception {
        boolean palindrome = target.canPermutePalindrome("code");
        assertFalse(palindrome);
    }

    @Test
    public void testCanPermutePalindrome2() throws Exception {
        boolean palindrome = target.canPermutePalindrome("aab");
        assertTrue(palindrome);
    }

    @Test
    public void testCanPermutePalindrome3() throws Exception {
        boolean palindrome = target.canPermutePalindrome("carerac");
        assertTrue(palindrome);
    }
}
