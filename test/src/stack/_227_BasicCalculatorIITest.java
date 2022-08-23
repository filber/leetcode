package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _227_BasicCalculatorIITest {

    _227_BasicCalculatorII target = null;

    @Before
    public void before() throws Exception {
        target = new _227_BasicCalculatorII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCalculate1() throws Exception {
        int val = target.calculate("3+2*2");
        assertEquals(7, val);
    }

    @Test
    public void testCalculate2() throws Exception {
        int val = target.calculate(" 3/2 ");
        assertEquals(1, val);
    }

    @Test
    public void testCalculate3() throws Exception {
        int val = target.calculate(" 3+5 / 2 ");
        assertEquals(5, val);
    }

    @Test
    public void testCalculate4() throws Exception {
        int val = target.calculate("1-1+1");
        assertEquals(1, val);
    }

    @Test
    public void testCalculate5() throws Exception {
        int val = target.calculate("0-2147483647");
        assertEquals(-2147483647, val);
    }

    @Test
    public void testCalculate6() throws Exception {
        int val = target.calculate("1+1-1");
        assertEquals(1, val);
    }
}
