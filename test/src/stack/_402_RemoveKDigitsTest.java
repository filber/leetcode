package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _402_RemoveKDigitsTest {

    _402_RemoveKDigits target = null;

    @Before
    public void before() throws Exception {
        target = new _402_RemoveKDigits();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRemoveKdigits1() throws Exception {
        String s = target.removeKdigits("10432219", 3);
        assertEquals("2219", s);
    }

    @Test
    public void testRemoveKdigits2() throws Exception {
        String s = target.removeKdigits("10200", 1);
        assertEquals("200", s);
    }

    @Test
    public void testRemoveKdigits3() throws Exception {
        String s = target.removeKdigits("10200", 2);
        assertEquals("0", s);
    }

    @Test
    public void testRemoveKdigits4() throws Exception {
        String s = target.removeKdigits("10", 2);
        assertEquals("0", s);
    }

    @Test
    public void testRemoveKdigits5() throws Exception {
        String s = target.removeKdigits("1234567", 2);
        assertEquals("12345", s);
    }

    @Test
    public void testRemoveKdigits6() throws Exception {
        String s = target.removeKdigits("2223122", 2);
        assertEquals("22122", s);
    }

    @Test
    public void testRemoveKdigits7() throws Exception {
        String s = target.removeKdigits("9", 1);
        assertEquals("0", s);
    }

    @Test
    public void testRemoveKdigits8() throws Exception {
        String s = target.removeKdigits("10001", 1);
        assertEquals("1", s);
    }

    @Test
    public void testRemoveKdigits9() throws Exception {
        String s = target.removeKdigits("1432219", 3);
        assertEquals("1219", s);
    }
}
