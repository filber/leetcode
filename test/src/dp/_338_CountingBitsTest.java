package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _338_CountingBitsTest {

    _338_CountingBits target = null;

    @Before
    public void before() throws Exception {
        target = new _338_CountingBits();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCountBits1() throws Exception {
        int[] bits = target.countBits(2);
        assertArrayEquals(new int[]{0, 1, 1}, bits);
    }

    @Test
    public void testCountBits2() throws Exception {
        int[] bits = target.countBits(5);
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, bits);
    }

    @Test
    public void testCountBits3() throws Exception {
        int[] bits = target.countBits(15);
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4}, bits);
    }
}
