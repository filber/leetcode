package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _198_HouseRobberTest {

    _198_HouseRobber target;

    @Before
    public void setUp() {
        target = new _198_HouseRobber();
    }

    @Test
    public void testRob1() {
        int[] nums = new int[]{1, 2, 3, 1};
        int amount = target.rob(nums);
        // 1 + 3
        assertEquals(4, amount);
    }

    @Test
    public void testRob2() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int amount = target.rob(nums);
        // 2+9+1=12
        assertEquals(12, amount);
    }
}