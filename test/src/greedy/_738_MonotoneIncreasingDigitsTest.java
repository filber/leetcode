package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _738_MonotoneIncreasingDigitsTest {

    _738_MonotoneIncreasingDigits target = null;

    @Before
    public void before() throws Exception {
        target = new _738_MonotoneIncreasingDigits();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMonotoneIncreasingDigits1() throws Exception {
        int val = target.monotoneIncreasingDigits(10);
        assertEquals(9, val);
    }

    @Test
    public void testMonotoneIncreasingDigits2() throws Exception {
        int val = target.monotoneIncreasingDigits(1234);
        assertEquals(1234, val);
    }

    @Test
    public void testMonotoneIncreasingDigits3() throws Exception {
        int val = target.monotoneIncreasingDigits(332);
        assertEquals(299, val);
    }

    @Test
    public void testMonotoneIncreasingDigits4() throws Exception {
        int val = target.monotoneIncreasingDigits(1110);
        assertEquals(999, val);
    }

    @Test
    public void testMonotoneIncreasingDigits5() throws Exception {
        int val = target.monotoneIncreasingDigits(12221);
        assertEquals(11999, val);
    }

    @Test
    public void testMonotoneIncreasingDigits6() throws Exception {
        int val = target.monotoneIncreasingDigits(1000);
        assertEquals(999, val);
    }
}
