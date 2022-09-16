package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _670_MaximumSwapTest {

    _670_MaximumSwap target = null;

    @Before
    public void before() throws Exception {
        target = new _670_MaximumSwap();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaximumSwap1() throws Exception {
        int max = target.maximumSwap(2736);
        assertEquals(7236, max);
    }

    @Test
    public void testMaximumSwap2() throws Exception {
        int max = target.maximumSwap(9973);
        assertEquals(9973, max);
    }

    @Test
    public void testMaximumSwap3() throws Exception {
        int max = target.maximumSwap(98368);
        assertEquals(98863, max);
    }

    @Test
    public void testMaximumSwap4() throws Exception {
        int max = target.maximumSwap(22341345);
        assertEquals(52341342, max);
    }
}
