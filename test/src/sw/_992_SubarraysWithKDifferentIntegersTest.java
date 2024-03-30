package sw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _992_SubarraysWithKDifferentIntegersTest {

    _992_SubarraysWithKDifferentIntegers target;

    @Before
    public void setUp() {
        target = new _992_SubarraysWithKDifferentIntegers();
    }

    @Test
    public void testSubarraysWithKDistinct1() {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        int cnt = target.subarraysWithKDistinct(nums, k);
        assertEquals(7, cnt);
    }

    @Test
    public void testSubarraysWithKDistinct2() {
        int[] nums = {1, 2, 1, 3, 4};
        int k = 3;
        int cnt = target.subarraysWithKDistinct(nums, k);
        assertEquals(3, cnt);
    }
}