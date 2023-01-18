package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _53_MaximumSubarrayTest {

    _53_MaximumSubarray target = null;

    @Before
    public void before() throws Exception {
        target = new _53_MaximumSubarray();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaxSubArray1() throws Exception {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = target.maxSubArray(nums);
        assertEquals(6, max);
    }

    @Test
    public void testMaxSubArray2() throws Exception {
        int[] nums = new int[]{1};
        int max = target.maxSubArray(nums);
        assertEquals(1, max);
    }

    @Test
    public void testMaxSubArray3() throws Exception {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        int max = target.maxSubArray(nums);
        assertEquals(23, max);
    }
}
