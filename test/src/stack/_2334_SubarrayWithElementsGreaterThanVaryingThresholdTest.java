package stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2334_SubarrayWithElementsGreaterThanVaryingThresholdTest {

    _2334_SubarrayWithElementsGreaterThanVaryingThreshold target;

    @Before
    public void setUp() throws Exception {
        target = new _2334_SubarrayWithElementsGreaterThanVaryingThreshold();
    }

    @Test
    public void testValidSubarraySize1() {
        int[] nums = {1, 3, 4, 3, 1};
        int threshold = 6;
        int size = target.validSubarraySize(nums, threshold);
        assertEquals(3, size);
    }

    @Test
    public void testValidSubarraySize2() {
        int[] nums = {6, 5, 6, 5, 8};
        int threshold = 7;
        int size = target.validSubarraySize(nums, threshold);
        assertEquals(3, size);
    }
}