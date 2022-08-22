package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _342_PowerOfFourTest {

    _342_PowerOfFour target;

    @Before
    public void before() throws Exception {
        target = new _342_PowerOfFour();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsPowerOfFour1() throws Exception {
        boolean is = target.isPowerOfFour(1);
        assertTrue(is);
    }

    @Test
    public void testIsPowerOfFour2() throws Exception {
        boolean is = target.isPowerOfFour(-1);
        assertFalse(is);
    }

    @Test
    public void testIsPowerOfFour3() throws Exception {
        boolean is = target.isPowerOfFour(4);
        assertTrue(is);
    }

    @Test
    public void testIsPowerOfFour4() throws Exception {
        boolean is = target.isPowerOfFour(5);
        assertFalse(is);
    }

    @Test
    public void testIsPowerOfFour5() throws Exception {
        boolean is = target.isPowerOfFour(16);
        assertTrue(is);
    }

} 
