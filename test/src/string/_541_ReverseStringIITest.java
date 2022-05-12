package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _541_ReverseStringIITest {

    _541_ReverseStringII target = null;

    @Before
    public void before() throws Exception {
        target = new _541_ReverseStringII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testReverseStr1() throws Exception {
        String reversed = target.reverseStr("abcdefg", 1);
        assertEquals("abcdefg", reversed);
    }

    @Test
    public void testReverseStr2() throws Exception {
        String reversed = target.reverseStr("abcdefg", 2);
        assertEquals("bacdfeg", reversed);
    }

    @Test
    public void testReverseStr3() throws Exception {
        String reversed = target.reverseStr("abcd", 2);
        assertEquals("bacd", reversed);
    }

    @Test
    public void testReverseStr4() throws Exception {
        String reversed = target.reverseStr("abcdefgh", 3);
        assertEquals("cbadefhg", reversed);
    }
}