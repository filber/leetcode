package sw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2958_LengthOfLongestSubarrayWithAtMostKFrequencyTest {

    _2958_LengthOfLongestSubarrayWithAtMostKFrequency target;

    @Before
    public void setUp() {
        target = new _2958_LengthOfLongestSubarrayWithAtMostKFrequency();
    }

    @Test
    public void testMaxSubarrayLength1() {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        int len = target.maxSubarrayLength(nums, k);
        // [1, 2, 3, 1, 2, 3]
        assertEquals(6, len);
    }

    @Test
    public void testMaxSubarrayLength2() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2};
        int k = 1;
        int len = target.maxSubarrayLength(nums, k);
        // [1, 2]
        assertEquals(2, len);
    }

    @Test
    public void testMaxSubarrayLength3() {
        int[] nums = {5, 5, 5, 5, 5, 5, 5};
        int k = 4;
        int len = target.maxSubarrayLength(nums, k);
        // [5, 5, 5, 5]
        assertEquals(4, len);
    }

    @Test
    public void testMaxSubarrayLength4() {
        int[] nums = {1, 2, 2, 1, 3};
        int k = 1;
        int len = target.maxSubarrayLength(nums, k);
        // [2, 1, 3]
        assertEquals(3, len);
    }
}