package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _300_LongestIncreasingSubsequenceTest {

    _300_LongestIncreasingSubsequence target = null;

    @Before
    public void before() throws Exception {
        target = new _300_LongestIncreasingSubsequence();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLengthOfLIS1() throws Exception {
        // [2,5,101]
        int len = target.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 1, 101, 18});
        assertEquals(3, len);
    }

    @Test
    public void testLengthOfLIS2() throws Exception {
        // [2,5,7,101]
        int len = target.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        assertEquals(4, len);
    }

    @Test
    public void testLengthOfLIS3() throws Exception {
        // [0,1,2,3]
        int len = target.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        assertEquals(4, len);
    }

    @Test
    public void testLengthOfLIS4() throws Exception {
        // [7]
        int len = target.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
        assertEquals(1, len);
    }
}
