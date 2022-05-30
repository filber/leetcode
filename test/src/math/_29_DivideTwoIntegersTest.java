package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _29_DivideTwoIntegersTest {

    _29_DivideTwoIntegers target = null;

    @Before
    public void before() throws Exception {
        target = new _29_DivideTwoIntegers();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDivide1() throws Exception {
        int rst = target.divide(10, 3);
        assertEquals(3, rst);
    }

    @Test
    public void testDivide2() throws Exception {
        int rst = target.divide(9, 3);
        assertEquals(3, rst);
    }

    @Test
    public void testDivide3() throws Exception {
        int rst = target.divide(7, -3);
        assertEquals(-2, rst);
    }

    @Test
    public void testDivide4() throws Exception {
        int rst = target.divide(-7, 3);
        assertEquals(-2, rst);
    }

    @Test
    public void testDivide5() throws Exception {
        int rst = target.divide(-6, -3);
        assertEquals(2, rst);
    }

    @Test
    public void testDivide6() throws Exception {
        int rst = target.divide(-2147483648, -1);
        assertEquals(2147483647, rst);
    }
}
