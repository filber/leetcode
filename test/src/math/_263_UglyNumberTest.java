package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _263_UglyNumberTest {

    _263_UglyNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _263_UglyNumber();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsUgly1() throws Exception {
        assertTrue(target.isUgly(6));
    }

    @Test
    public void testIsUgly2() throws Exception {
        assertTrue(target.isUgly(1));
    }

    @Test
    public void testIsUgly3() throws Exception {
        assertTrue(target.isUgly(15));
    }

    @Test
    public void testIsUgly4() throws Exception {
        assertFalse(target.isUgly(14));
    }

    @Test
    public void testIsUgly5() throws Exception {
        assertFalse(target.isUgly(0));
    }

    @Test
    public void testIsUgly6() throws Exception {
        assertFalse(target.isUgly(-1));
    }
}
