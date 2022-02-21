package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1657_DetermineIfTwoStringsAreCloseTest {

    _1657_DetermineIfTwoStringsAreClose target = null;

    @Before
    public void before() throws Exception {
        target = new _1657_DetermineIfTwoStringsAreClose();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCloseStrings1() throws Exception {
        boolean close = target.closeStrings("abc", "bca");
        assertTrue(close);
    }

    @Test
    public void testCloseStrings2() throws Exception {
        boolean close = target.closeStrings("a", "aa");
        assertFalse(close);
    }

    @Test
    public void testCloseStrings3() throws Exception {
        boolean close = target.closeStrings("cabbba", "abbccc");
        assertTrue(close);
    }

    @Test
    public void testCloseStrings4() throws Exception {
        boolean close = target.closeStrings("cabbba", "aabbss");
        assertFalse(close);
    }

    @Test
    public void testCloseStrings5() throws Exception {
        boolean close = target.closeStrings("uau", "ssx");
        assertFalse(close);
    }
}
