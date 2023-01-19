package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _974_SubarraySumsDivisibleByKTest {

    _974_SubarraySumsDivisibleByK target = null;

    @Before
    public void before() throws Exception {
        target = new _974_SubarraySumsDivisibleByK();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSubarraysDivByK1() throws Exception {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        // [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
        int count = target.subarraysDivByK(nums, k);
        assertEquals(7, count);
    }

    @Test
    public void testSubarraysDivByK2() throws Exception {
        int[] nums = {5};
        int k = 9;
        int count = target.subarraysDivByK(nums, k);
        assertEquals(0, count);
    }

    @Test
    public void testSubarraysDivByK3() throws Exception {
        int[] nums = {-1, 2, 9};
        int k = 2;
        // [2], [-1,2,9]
        int count = target.subarraysDivByK(nums, k);
        assertEquals(2, count);
    }
}
