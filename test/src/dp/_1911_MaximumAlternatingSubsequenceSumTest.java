package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1911_MaximumAlternatingSubsequenceSumTest {

    _1911_MaximumAlternatingSubsequenceSum target = null;

    @Before
    public void before() throws Exception {
        target = new _1911_MaximumAlternatingSubsequenceSum();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaxAlternatingSum1() throws Exception {
        int[] nums = {4, 2, 5, 3};
        //[4,2,5] -> 4 + 5 - 2
        long sum = target.maxAlternatingSum(nums);
        assertEquals(7, sum);
    }

    @Test
    public void testMaxAlternatingSum2() throws Exception {
        int[] nums = {5, 6, 7, 8};
        //[8] -> 8
        long sum = target.maxAlternatingSum(nums);
        assertEquals(8, sum);
    }

    @Test
    public void testMaxAlternatingSum3() throws Exception {
        int[] nums = {6, 2, 1, 2, 4, 5};
        //[6,1,5] -> 10
        long sum = target.maxAlternatingSum(nums);
        assertEquals(10, sum);
    }

    @Test
    public void testMaxAlternatingSum4() throws Exception {
        int[] nums = {1};
        //[1] -> 1
        long sum = target.maxAlternatingSum(nums);
        assertEquals(1, sum);
    }

    @Test
    public void testMaxAlternatingSum5() throws Exception {
        int[] nums = {2, 2, 1};
        //[2] -> 2
        long sum = target.maxAlternatingSum(nums);
        assertEquals(2, sum);
    }
}
