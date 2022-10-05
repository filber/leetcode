package sw;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {

    _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit target = null;

    @Before
    public void before() throws Exception {
        target = new _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLongestSubarray1() throws Exception {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        int len = target.longestSubarray(nums, limit);
        //[2,4] or [4,7]
        assertEquals(2, len);
    }

    @Test
    public void testLongestSubarray2() throws Exception {
        int[] nums = {10, 1, 2, 4, 7, 2};
        int limit = 5;
        int len = target.longestSubarray(nums, limit);
        //[2,4,7,2]
        assertEquals(4, len);
    }

    @Test
    public void testLongestSubarray3() throws Exception {
        int[] nums = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit = 0;
        int len = target.longestSubarray(nums, limit);
        //[2,2,2]
        assertEquals(3, len);
    }
}
