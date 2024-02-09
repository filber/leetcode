package dp;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class _368_LargestDivisibleSubsetTest {

    _368_LargestDivisibleSubset target;

    @Before
    public void setUp() throws Exception {
        target = new _368_LargestDivisibleSubset();
    }

    @Test
    public void testLargestDivisibleSubset1() {
        int[] nums = {4, 8, 10, 240};
        List<Integer> result = target.largestDivisibleSubset(nums);
        assertArrayEquals(new Object[]{240, 8, 4}, result.toArray());
    }

    @Test
    public void testLargestDivisibleSubset2() {
        int[] nums = {1, 2, 3};
        List<Integer> result = target.largestDivisibleSubset(nums);
        assertArrayEquals(new Object[]{2, 1}, result.toArray());
    }

    @Test
    public void testLargestDivisibleSubset3() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = target.largestDivisibleSubset(nums);
        assertArrayEquals(new Object[]{8, 4, 2, 1}, result.toArray());
    }
}