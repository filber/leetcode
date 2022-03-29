package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _209_MinimumSizeSubarraySumTest {

    _209_MinimumSizeSubarraySum target = null;

    @Before
    public void before() throws Exception {
        target = new _209_MinimumSizeSubarraySum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinSubArrayLen1() throws Exception {
        int len = target.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        assertEquals(2, len);
    }

    @Test
    public void testMinSubArrayLen2() throws Exception {
        int len = target.minSubArrayLen(4, new int[]{1, 4, 4});
        assertEquals(1, len);
    }

    @Test
    public void testMinSubArrayLen3() throws Exception {
        int len = target.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        assertEquals(0, len);
    }
}
