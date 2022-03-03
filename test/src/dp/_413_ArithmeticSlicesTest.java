package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _413_ArithmeticSlicesTest {

    _413_ArithmeticSlices target = null;

    @Before
    public void before() throws Exception {
        target = new _413_ArithmeticSlices();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNumberOfArithmeticSlices1() throws Exception {
        int cnt = target.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9});
        assertEquals(6, cnt);
    }

    @Test
    public void testNumberOfArithmeticSlices2() throws Exception {
        int cnt = target.numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        assertEquals(3, cnt);
    }

    @Test
    public void testNumberOfArithmeticSlices3() throws Exception {
        int cnt = target.numberOfArithmeticSlices(new int[]{1});
        assertEquals(0, cnt);
    }

    @Test
    public void testNumberOfArithmeticSlices4() throws Exception {
        int cnt = target.numberOfArithmeticSlices(new int[]{-1, -2, 1, 2, 3, 4, 4, 4});
        assertEquals(4, cnt);
    }

    @Test
    public void testNumberOfArithmeticSlices5() throws Exception {
        int cnt = target.numberOfArithmeticSlices(new int[]{-1, -2, 1, 2, -3, 3});
        assertEquals(0, cnt);
    }
} 
