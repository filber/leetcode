package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1979_FindGreatestCommonDivisorOfArrayTest {

    _1979_FindGreatestCommonDivisorOfArray target = null;

    @Before
    public void before() throws Exception {
        target = new _1979_FindGreatestCommonDivisorOfArray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindGCD1() throws Exception {
        int n = target.findGCD(new int[]{2, 5, 6, 9, 10});
        assertEquals(2, n);
    }

    @Test
    public void testFindGCD2() throws Exception {
        int n = target.findGCD(new int[]{7, 5, 6, 8, 3});
        assertEquals(1, n);
    }

    @Test
    public void testFindGCD3() throws Exception {
        int n = target.findGCD(new int[]{3, 3});
        assertEquals(3, n);
    }
}
