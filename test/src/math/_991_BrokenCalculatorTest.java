package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _991_BrokenCalculatorTest {

    _991_BrokenCalculator target = null;

    @Before
    public void before() throws Exception {
        target = new _991_BrokenCalculator();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testBrokenCalc1() throws Exception {
        int res = target.brokenCalc(2, 3);
        assertEquals(2, res);
    }

    @Test
    public void testBrokenCalc2() throws Exception {
        int res = target.brokenCalc(5, 8);
        assertEquals(2, res);
    }

    @Test
    public void testBrokenCalc3() throws Exception {
        int res = target.brokenCalc(3, 10);
        assertEquals(3, res);
    }

    @Test
    public void testBrokenCalc4() throws Exception {
        int res = target.brokenCalc(1024, 1);
        assertEquals(1023, res);
    }
}
