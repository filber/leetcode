package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _480_SlidingWindowMedianTest {

    _480_SlidingWindowMedian target = null;

    @Before
    public void before() throws Exception {
        target = new _480_SlidingWindowMedian();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMedianSlidingWindow1() throws Exception {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        double[] medians = target.medianSlidingWindow(nums, 3);
        assertArrayEquals(new double[]{1.0, -1.0, -1.0, 3.0, 5.0, 6.0}, medians, 1e-5);
    }

    @Test
    public void testMedianSlidingWindow2() throws Exception {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        double[] medians = target.medianSlidingWindow(nums, 4);
        assertArrayEquals(new double[]{0.0, 1.0, 1.0, 4.0, 5.5}, medians, 1e-5);
    }

    @Test
    public void testMedianSlidingWindow3() throws Exception {
        int[] nums = {1, 2, 3, 4, 2, 3, 1, 4, 2};
        double[] medians = target.medianSlidingWindow(nums, 3);
        assertArrayEquals(new double[]{2.0, 3.0, 3.0, 3.0, 2.0, 3.0, 2.0}, medians, 1e-5);
    }

    @Test
    public void testMedianSlidingWindow4() throws Exception {
        int[] nums = {1, 2, 3, 4, 2, 3, 1, 4, 2};
        double[] medians = target.medianSlidingWindow(nums, 4);
        assertArrayEquals(new double[]{2.5, 2.5, 3.0, 2.5, 2.5, 2.5}, medians, 1e-5);
    }

    @Test
    public void testMedianSlidingWindow5() throws Exception {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        double[] medians = target.medianSlidingWindow(nums, 3);
        assertArrayEquals(new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0}, medians, 1e-5);
    }

    @Test
    public void testMedianSlidingWindow6() throws Exception {
        int[] nums = {2147483647, 2147483647};
        double[] medians = target.medianSlidingWindow(nums, 2);
        assertArrayEquals(new double[]{2147483647.00000}, medians, 1e-5);
    }
}
