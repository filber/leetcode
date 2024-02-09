package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _312_BurstBalloonsTest {

    _312_BurstBalloons target;

    @Before
    public void setUp() throws Exception {
        target = new _312_BurstBalloons();
    }

    @Test
    public void testMaxCoins1() {
        int[] nums = {4};
        int max = target.maxCoins(nums); // 4
        assertEquals(4, max);
    }

    @Test
    public void testMaxCoins2() {
        int[] nums = {1, 5};
        int max = target.maxCoins(nums);
        // {1,5} -> {5} -> {}
        //       +5     +5  = 10
        assertEquals(10, max);
    }

    @Test
    public void testMaxCoins3() {
        int[] nums = {3, 1, 5, 8};
        int max = target.maxCoins(nums);
        assertEquals(167, max);
    }
}