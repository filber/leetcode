package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1362_ClosestDivisorsTest {

    _1362_ClosestDivisors target = null;

    @Before
    public void before() throws Exception {
        target = new _1362_ClosestDivisors();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testClosestDivisors1() throws Exception {
        // [3,3]
        int[] divisors = target.closestDivisors(8);
        assertArrayEquals(new int[]{3, 3}, divisors);
    }

    @Test
    public void testClosestDivisors2() throws Exception {
        int[] divisors = target.closestDivisors(123);
        assertArrayEquals(new int[]{5, 25}, divisors);
    }

    @Test
    public void testClosestDivisors3() throws Exception {
        int[] divisors = target.closestDivisors(999);
        assertArrayEquals(new int[]{25, 40}, divisors);
    }

    @Test
    public void testClosestDivisors4() throws Exception {
        int[] divisors = target.closestDivisors(1);
        assertArrayEquals(new int[]{1, 2}, divisors);
    }

    @Test
    public void testClosestDivisors5() throws Exception {
        int[] divisors = target.closestDivisors(2);
        assertArrayEquals(new int[]{2, 2}, divisors);
    }
}
