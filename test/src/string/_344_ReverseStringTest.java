package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _344_ReverseStringTest {

    _344_ReverseString target = null;

    @Before
    public void before() throws Exception {
        target = new _344_ReverseString();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testReverseString1() throws Exception {
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o' };
        target.reverseString(arr);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h' }, arr);
    }

    @Test
    public void testReverseString2() throws Exception {
        char[] arr = new char[]{'H' };
        target.reverseString(arr);
        assertArrayEquals(new char[]{'H' }, arr);
    }

    @Test
    public void testReverseString3() throws Exception {
        char[] arr = new char[]{'h', 'e', 'l', 'o' };
        target.reverseString(arr);
        assertArrayEquals(new char[]{'o', 'l', 'e', 'h' }, arr);
    }
}
