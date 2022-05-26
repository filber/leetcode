package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _674_LongestContinuousIncreasingSubsequenceTest {

    _674_LongestContinuousIncreasingSubsequence target = null;

    @Before
    public void before() throws Exception {
        target = new _674_LongestContinuousIncreasingSubsequence();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindLengthOfLCIS1() throws Exception {
        int[] nums = {1, 3, 5, 4, 7};
        int len = target.findLengthOfLCIS(nums);
        assertEquals(3, len);
    }

    @Test
    public void testFindLengthOfLCIS2() throws Exception {
        int[] nums = {2, 2, 2, 2, 2};
        int len = target.findLengthOfLCIS(nums);
        assertEquals(1, len);
    }
}
