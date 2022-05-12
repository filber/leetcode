package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _345_ReverseVowelsOfAStringTest {

    _345_ReverseVowelsOfAString target = null;

    @Before
    public void before() throws Exception {
        target = new _345_ReverseVowelsOfAString();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testReverseVowels1() throws Exception {
        String reversed = target.reverseVowels("hello");
        assertEquals("holle", reversed);
    }

    @Test
    public void testReverseVowels2() throws Exception {
        String reversed = target.reverseVowels("leetcode");
        assertEquals("leotcede", reversed);
    }

    @Test
    public void testReverseVowels3() throws Exception {
        String reversed = target.reverseVowels("abc");
        assertEquals("abc", reversed);
    }

    @Test
    public void testReverseVowels4() throws Exception {
        String reversed = target.reverseVowels("bcd");
        assertEquals("bcd", reversed);
    }

    @Test
    public void testReverseVowels5() throws Exception {
        String reversed = target.reverseVowels("aA");
        assertEquals("Aa", reversed);
    }
}
