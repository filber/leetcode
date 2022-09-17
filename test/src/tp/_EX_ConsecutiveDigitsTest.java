package tp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_ConsecutiveDigitsTest {

    _EX_ConsecutiveDigits target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_ConsecutiveDigits();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCompress() throws Exception {
        String rst = target.compress("999433");
        assertEquals("2746", rst);
    }

    @Test
    public void testCompress2() throws Exception {
        String rst = target.compress("44488366664");
        assertEquals("12163244", rst);
    }

    @Test
    public void testCompress3() throws Exception {
        String rst = target.compress("123456");
        assertEquals("123456", rst);
    }

    @Test
    public void testCompress4() throws Exception {
        String rst = target.compress("9994331");
        assertEquals("27461", rst);
    }

    @Test
    public void testCompress5() throws Exception {
        String rst = target.compress("66644319333");
        assertEquals("26328", rst);
    }
}
