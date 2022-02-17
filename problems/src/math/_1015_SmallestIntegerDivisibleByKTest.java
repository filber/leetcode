package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1015_SmallestIntegerDivisibleByKTest {

    _1015_SmallestIntegerDivisibleByK target = null;

    @Before
    public void before() throws Exception {
        target = new _1015_SmallestIntegerDivisibleByK();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSmallestRepunitDivByK1() throws Exception {
        int val = target.smallestRepunitDivByK(1);
        assertEquals(1, val);
    }

    @Test
    public void testSmallestRepunitDivByK2() throws Exception {
        int val = target.smallestRepunitDivByK(2);
        assertEquals(-1, val);
    }

    @Test
    public void testSmallestRepunitDivByK3() throws Exception {
        int val = target.smallestRepunitDivByK(3);
        assertEquals(3, val);
    }

    @Test
    public void testSmallestRepunitDivByK4() throws Exception {
        int val = target.smallestRepunitDivByK(5);
        assertEquals(-1, val);
    }

    @Test
    public void testSmallestRepunitDivByK5() throws Exception {
        int val = target.smallestRepunitDivByK(17);
        assertEquals(16, val);
    }
}
