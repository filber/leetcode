package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _376_WiggleSubsequenceTest {

    _376_WiggleSubsequence target = null;

    @Before
    public void before() throws Exception {
        target = new _376_WiggleSubsequence();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testWiggleMaxLength1() throws Exception {
        int[] nums = {1, 1, 1, 1, 1};
        int maxLen = target.wiggleMaxLength(nums);
        assertEquals(1, maxLen);
    }

    @Test
    public void testWiggleMaxLength2() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int maxLen = target.wiggleMaxLength(nums);
        assertEquals(2, maxLen);
    }

    @Test
    public void testWiggleMaxLength3() throws Exception {
        int[] nums = {1, 7, 4, 9, 2, 5};
        int maxLen = target.wiggleMaxLength(nums);
        assertEquals(6, maxLen);
    }

    @Test
    public void testWiggleMaxLength4() throws Exception {
        //[1, 17, 10, 13, 10, 16, 8]
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int maxLen = target.wiggleMaxLength(nums);
        assertEquals(7, maxLen);
    }

    @Test
    public void testWiggleMaxLength5() throws Exception {
        int[] nums = {1};
        int maxLen = target.wiggleMaxLength(nums);
        assertEquals(1, maxLen);
    }

    @Test
    public void testWiggleMaxLength6() throws Exception {
        int[] nums = {1, 2};
        int maxLen = target.wiggleMaxLength(nums);
        assertEquals(2, maxLen);
    }

    @Test
    public void testWiggleMaxLength7() throws Exception {
        int[] nums = {2, 1};
        int maxLen = target.wiggleMaxLength(nums);
        assertEquals(2, maxLen);
    }
}
