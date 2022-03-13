package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1547_MinimumCostToCutAStickTest {

    _1547_MinimumCostToCutAStick target = null;

    @Before
    public void before() throws Exception {
        target = new _1547_MinimumCostToCutAStick();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMinCost1() throws Exception {
        int cost = target.minCost(7, new int[]{1, 3, 4, 5});
        assertEquals(16, cost);
    }

    @Test
    public void testMinCost2() throws Exception {
        int cost = target.minCost(9, new int[]{5, 6, 1, 4, 2});
        assertEquals(22, cost);
    }

    @Test
    public void testMinCost3() throws Exception {
        int cost = target.minCost(10, new int[]{7, 8, 9, 2, 1});
        assertEquals(24, cost);
    }

    @Test
    public void testMinCost4() throws Exception {
        int cost = target.minCost(2, new int[]{1});
        assertEquals(2, cost);
    }

    @Test
    public void testMinCost5() throws Exception {
        int cost = target.minCost(3, new int[]{1});
        assertEquals(3, cost);
    }

    @Test
    public void testMinCost6() throws Exception {
        int cost = target.minCost(3, new int[]{1, 2});
        assertEquals(5, cost);
    }
}
