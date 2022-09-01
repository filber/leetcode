package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _327_CountOfRangeSumTest {

    _327_CountOfRangeSum target = null;

    @Before
    public void before() throws Exception {
        target = new _327_CountOfRangeSum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCountRangeSum1() throws Exception {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        int count = target.countRangeSum(nums, lower, upper);
        // [-2], [-1], [-2, 5, -1]
        assertEquals(3, count);
    }

    @Test
    public void testCountRangeSum2() throws Exception {
        int[] nums = {0};
        int lower = 0;
        int upper = 0;
        int count = target.countRangeSum(nums, lower, upper);
        // [0]
        assertEquals(1, count);
    }

    @Test
    public void testCountRangeSum3() throws Exception {
        int[] nums = {1, 2, 3, 4, 5};
        int lower = 3;
        int upper = 8;
        int count = target.countRangeSum(nums, lower, upper);
        assertEquals(7, count);
    }
}
