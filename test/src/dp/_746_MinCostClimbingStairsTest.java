package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _746_MinCostClimbingStairsTest {

    _746_MinCostClimbingStairs target = null;

    @Before
    public void before() throws Exception {
        target = new _746_MinCostClimbingStairs();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinCostClimbingStairs1() throws Exception {
        int cost = target.minCostClimbingStairs(new int[]{10, 15, 20});
        assertEquals(15, cost);
    }

    @Test
    public void testMinCostClimbingStairs2() throws Exception {
        int cost = target.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        assertEquals(6, cost);
    }
}
