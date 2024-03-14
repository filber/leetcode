package sw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _930_BinarySubarraysWithSumTest {

    _930_BinarySubarraysWithSum target;

    @Before
    public void setUp() throws Exception {
        target = new _930_BinarySubarraysWithSum();
    }

    @Test
    public void testNumSubarraysWithSum1() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int count = target.numSubarraysWithSum(nums, goal);
        // [1,0,1],[1,0,1,0],[0,1,0,1],[1,0,1]
        assertEquals(4, count);
    }

    @Test
    public void testNumSubarraysWithSum2() {
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
        int count = target.numSubarraysWithSum(nums, goal);
        assertEquals(15, count);
    }
}