package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _16_3SumClosestTest {

    _16_3SumClosest target = null;

    @Before
    public void before() throws Exception {
        target = new _16_3SumClosest();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testThreeSumClosest1() throws Exception {
        int[] nums = {-1, 2, 1, -4};
        int t = 1;
        int closest = target.threeSumClosest(nums, t);
        // [-1,1,2]
        assertEquals(2, closest);
    }

    @Test
    public void testThreeSumClosest2() throws Exception {
        int[] nums = {0, 0, 0};
        int t = 1;
        int closest = target.threeSumClosest(nums, t);
        // [0, 0, 0]
        assertEquals(0, closest);
    }

    @Test
    public void testThreeSumClosest3() throws Exception {
        int[] nums = {0, 2, 1, -3};
        int t = 1;
        int closest = target.threeSumClosest(nums, t);
        // [-3, 1, 2]
        assertEquals(0, closest);
    }
} 
