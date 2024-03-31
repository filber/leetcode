package sw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2444_CountSubarraysWithFixedBoundsTest {

    _2444_CountSubarraysWithFixedBounds target;

    @Before
    public void setUp() throws Exception {
        target = new _2444_CountSubarraysWithFixedBounds();
    }

    @Test
    public void testCountSubarrays1() {
        int[] nums = {1,3,5,2,7,5};
        int minK = 1;
        int maxK = 5;
        long count = target.countSubarrays(nums, minK, maxK);
        assertEquals(2L, count);
    }

    @Test
    public void testCountSubarrays2() {
        int[] nums = {1, 1, 1, 1};
        int minK = 1;
        int maxK = 1;
        long count = target.countSubarrays(nums, minK, maxK);
        assertEquals(10L, count);
    }
}