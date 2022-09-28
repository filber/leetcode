package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _560_SubarraySumEqualsKTest {

    _560_SubarraySumEqualsK target = null;

    @Before
    public void before() throws Exception {
        target = new _560_SubarraySumEqualsK();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSubarraySum1() throws Exception {
        int[] nums = {1, 1, 1};
        int k = 2;
        int count = target.subarraySum(nums, k);
        //[1,1],[1,1]
        assertEquals(2, count);
    }

    @Test
    public void testSubarraySum2() throws Exception {
        int[] nums = {1, 2, 3};
        int k = 3;
        int count = target.subarraySum(nums, k);
        //[1,2],[3]
        assertEquals(2, count);
    }

    @Test
    public void testSubarraySum3() throws Exception {
        int[] nums = {-1, 1, -1, 2, -2, 4, -2};
        int k = 0;
        int count = target.subarraySum(nums, k);
        //[-1,1],[1,-1],[1,-1,2,-2],[2,-2],[-2,4,-2]
        assertEquals(5, count);
    }
}
