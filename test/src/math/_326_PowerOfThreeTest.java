package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _326_PowerOfThreeTest {

    _326_PowerOfThree target;

    @Before
    public void before() throws Exception {
        target = new _326_PowerOfThree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsPowerOfThree1() throws Exception {
        // 16 + 8 + 2 + 1
        // 11011
        boolean is = target.isPowerOfThree(27);
        assertTrue(is);
    }

    @Test
    public void testIsPowerOfThree2() throws Exception {
        // 1
        boolean is = target.isPowerOfThree(1);
        assertTrue(is);
    }

    @Test
    public void testIsPowerOfThree3() throws Exception {
        // 1001
        boolean is = target.isPowerOfThree(9);
        assertTrue(is);
    }

    @Test
    public void testIsPowerOfThree4() throws Exception {
        boolean is = target.isPowerOfThree(0);
        assertFalse(is);
    }
} 
