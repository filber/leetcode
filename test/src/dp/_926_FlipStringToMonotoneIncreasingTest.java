package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _926_FlipStringToMonotoneIncreasingTest {

    _926_FlipStringToMonotoneIncreasing target = null;

    @Before
    public void before() throws Exception {
        target = new _926_FlipStringToMonotoneIncreasing();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinFlipsMonoIncr1() throws Exception {
        int flips = target.minFlipsMonoIncr("00110");
        assertEquals(1, flips);
    }

    @Test
    public void testMinFlipsMonoIncr2() throws Exception {
        int flips = target.minFlipsMonoIncr("010110");
        // 011111 or 000111
        assertEquals(2, flips);
    }

    @Test
    public void testMinFlipsMonoIncr3() throws Exception {
        int flips = target.minFlipsMonoIncr("00011000");
        // 00000000
        assertEquals(2, flips);
    }
}
