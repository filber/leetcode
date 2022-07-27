package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1508_RangeSumOfSortedSubarraySumsTest {

    _1508_RangeSumOfSortedSubarraySums target = null;

    @Before
    public void before() throws Exception {
        target = new _1508_RangeSumOfSortedSubarraySums();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRangeSum1() throws Exception {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 5;
        int sum = target.rangeSum(nums, n, left, right);
        assertEquals(13, sum);
    }

    @Test
    public void testRangeSum2() throws Exception {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 3;
        int right = 4;
        int sum = target.rangeSum(nums, n, left, right);
        assertEquals(6, sum);
    }

    @Test
    public void testRangeSum3() throws Exception {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 10;
        int sum = target.rangeSum(nums, n, left, right);
        assertEquals(50, sum);
    }

    @Test
    public void testCountK1() throws Exception {
        int[] A = {1, 2, 3, 4};
        long[] count = target.countK(A, 4);
        // 1,2,3,3,4
        assertArrayEquals(new long[]{5, 13}, count);
    }
}
