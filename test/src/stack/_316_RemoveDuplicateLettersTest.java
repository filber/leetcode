package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import stack._316_RemoveDuplicateLetters;

import static org.junit.Assert.*;

public class _316_RemoveDuplicateLettersTest {

    _316_RemoveDuplicateLetters target = null;

    @Before
    public void before() throws Exception {
        target = new _316_RemoveDuplicateLetters();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRemoveDuplicateLetters1() throws Exception {
        String str = target.removeDuplicateLetters("bcabc");
        assertEquals("abc", str);
    }

    @Test
    public void testRemoveDuplicateLetters2() throws Exception {
        String str = target.removeDuplicateLetters("cbacdcbc");
        assertEquals("acdb", str);
    }

    @Test
    public void testRemoveDuplicateLetters3() throws Exception {
        String str = target.removeDuplicateLetters("aabecfdef");
        assertEquals("abcdef", str);
    }

    @Test
    public void testRemoveDuplicateLetters4() throws Exception {
        String str = target.removeDuplicateLetters("aabbccddeeff");
        assertEquals("abcdef", str);
    }
}
