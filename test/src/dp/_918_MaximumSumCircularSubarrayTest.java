package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _918_MaximumSumCircularSubarrayTest {

    _918_MaximumSumCircularSubarray target = null;

    @Before
    public void before() throws Exception {
        target = new _918_MaximumSumCircularSubarray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxSubarraySumCircular1() throws Exception {
        int[] nums = {1, -2, 3, -2};
        int max = target.maxSubarraySumCircular(nums);
        assertEquals(3, max);
    }

    @Test
    public void testMaxSubarraySumCircular2() throws Exception {
        int[] nums = {5, -3, 5};
        int max = target.maxSubarraySumCircular(nums);
        assertEquals(10, max);
    }

    @Test
    public void testMaxSubarraySumCircular3() throws Exception {
        int[] nums = {-3, -2, -3};
        int max = target.maxSubarraySumCircular(nums);
        assertEquals(-2, max);
    }
}
