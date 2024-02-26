package sw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimesTest {

    _2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes target;

    @Before
    public void setUp() throws Exception {
        target = new _2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
    }

    @Test
    public void testCountSubarrays1() {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        long count = target.countSubarrays(nums, k);
        assertEquals(6L, count);
    }

    @Test
    public void testCountSubarrays2() {
        int[] nums = {1, 4, 2, 1};
        int k = 3;
        long count = target.countSubarrays(nums, k);
        assertEquals(0L, count);
    }
}