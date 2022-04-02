package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _680_ValidPalindromeIITest {

    _680_ValidPalindromeII target = null;

    @Before
    public void before() throws Exception {
        target = new _680_ValidPalindromeII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testValidPalindrome1() throws Exception {
        boolean valid = target.validPalindrome("aba");
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome2() throws Exception {
        boolean valid = target.validPalindrome("abca");
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome3() throws Exception {
        boolean valid = target.validPalindrome("abc");
        assertFalse(valid);
    }

    @Test
    public void testValidPalindrome4() throws Exception {
        boolean valid = target.validPalindrome("aa");
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome5() throws Exception {
        boolean valid = target.validPalindrome("aab");
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome6() throws Exception {
        boolean valid = target.validPalindrome("aabb");
        assertFalse(valid);
    }

    @Test
    public void testValidPalindrome7() throws Exception {
        boolean valid = target.validPalindrome("eeccccbebaeeabebccceea");
        assertFalse(valid);
    }

    @Test
    public void testValidPalindrome8() throws Exception {
        boolean valid = target.validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu");
        assertTrue(valid);
    }

    @Test
    public void testValidPalindrome9() throws Exception {
        boolean valid = target.validPalindrome("pidbliassaqozokmtgahluruufwbjdtayuhbxwoicviygilgzduudzgligyviciowxbhuyatdjbwfuurulhagtmkozoqassailbdip");
        assertFalse(valid);
    }
}
