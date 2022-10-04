package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _204_CountPrimesTest {

    _204_CountPrimes target;

    @Before
    public void before() throws Exception {
        target = new _204_CountPrimes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCountPrimes1() throws Exception {
        int count = target.countPrimes(10);
        // 2,3,5,7
        assertEquals(4, count);
    }

    @Test
    public void testCountPrimes2() throws Exception {
        int count = target.countPrimes(0);
        assertEquals(0, count);
    }

    @Test
    public void testCountPrimes3() throws Exception {
        int count = target.countPrimes(1);
        assertEquals(0, count);
    }
}
