package ps;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _523_ContinuousSubarraySumTest {

    _523_ContinuousSubarraySum target;

    @Before
    public void before() throws Exception {
        target = new _523_ContinuousSubarraySum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCheckSubarraySum1() throws Exception {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        boolean check = target.checkSubarraySum(nums, k);
        // [2,4] = 1*6
        assertTrue(check);
    }

    @Test
    public void testCheckSubarraySum2() throws Exception {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 6;
        boolean check = target.checkSubarraySum(nums, k);
        // [2,6,4] = 2*6
        assertTrue(check);
    }

    @Test
    public void testCheckSubarraySum3() throws Exception {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 13;
        boolean check = target.checkSubarraySum(nums, k);
        assertFalse(check);
    }

    @Test
    public void testCheckSubarraySum4() throws Exception {
        //[23,25,29,35,41]
        //[ 2, 4, 1, 0, 6]
        int[] nums = {23, 2, 4, 6, 6};
        int k = 7;
        boolean check = target.checkSubarraySum(nums, k);
        assertTrue(check);
    }
}
