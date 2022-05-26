package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _343_IntegerBreakTest {

    _343_IntegerBreak target = null;

    @Before
    public void before() throws Exception {
        target = new _343_IntegerBreak();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIntegerBreak1() throws Exception {
        // [1*1]
        int product = target.integerBreak(2);
        assertEquals(1, product);
    }

    @Test
    public void testIntegerBreak2() throws Exception {
        // [2*3]
        int product = target.integerBreak(5);
        assertEquals(6, product);
    }

    @Test
    public void testIntegerBreak3() throws Exception {
        // [3*3*4]
        int product = target.integerBreak(10);
        assertEquals(36, product);
    }

    @Test
    public void testIntegerBreak4() throws Exception {
        int product = target.integerBreak(30);
        assertEquals(59049, product);
    }

    @Test
    public void testIntegerBreak5() throws Exception {
        int product = target.integerBreak(58);
        assertEquals(1549681956, product);
    }
}
