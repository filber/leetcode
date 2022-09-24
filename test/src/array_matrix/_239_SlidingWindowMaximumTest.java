package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _239_SlidingWindowMaximumTest {

    _239_SlidingWindowMaximum target;

    @Before
    public void before() throws Exception {
        target = new _239_SlidingWindowMaximum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxSlidingWindow1() throws Exception {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] actual = target.maxSlidingWindow(nums, k);
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMaxSlidingWindow2() throws Exception {
        int[] nums = new int[]{1, 3, -1, 0, -2, 5, 3, 6, 7};
        int k = 3;
        int[] actual = target.maxSlidingWindow(nums, k);
        int[] expected = {3, 3, 0, 5, 5, 6, 7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMaxSlidingWindow3() throws Exception {
        int[] nums = new int[]{1};
        int k = 1;
        int[] actual = target.maxSlidingWindow(nums, k);
        int[] expected = {1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMaxSlidingWindow4() throws Exception {
        int[] nums = new int[]{7, 2, 4};
        int k = 2;
        int[] actual = target.maxSlidingWindow(nums, k);
        int[] expected = {7, 4};
        assertArrayEquals(expected, actual);
    }
}
