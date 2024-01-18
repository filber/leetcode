package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1664_WaysToMakeAFairArrayTest {

    _1664_WaysToMakeAFairArray target;

    @Before
    public void setUp() throws Exception {
        target = new _1664_WaysToMakeAFairArray();
    }

    @Test
    public void testWaysToMakeFair1() {
        int[] nums = {2, 1, 6, 4};
        int ways = target.waysToMakeFair(nums);
        assertEquals(1, ways);
    }

    @Test
    public void testWaysToMakeFair2() {
        int[] nums = {1, 1, 1};
        int ways = target.waysToMakeFair(nums);
        assertEquals(3, ways);
    }

    @Test
    public void testWaysToMakeFair3() {
        int[] nums = {1, 2, 3};
        int ways = target.waysToMakeFair(nums);
        assertEquals(0, ways);
    }

    @Test
    public void testWaysToMakeFair4() {
        int[] nums = {1};
        int ways = target.waysToMakeFair(nums);
        assertEquals(1, ways);
    }
}