package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _983_MinimumCostForTicketsTest {

    _983_MinimumCostForTickets target;

    @Before
    public void setUp() {
        target = new _983_MinimumCostForTickets();
    }

    @Test
    public void testMinCostTickets1() {
        int[] cost = {2, 7, 15};
        int[] days = {1, 4, 6, 7, 8, 20};
        int minCost = target.mincostTickets(days, cost);
        // 11 = 2{1} + 7{4,6,7,8} + 2{20}
        assertEquals(11, minCost);
    }

    @Test
    public void testMinCostTickets2() {
        int[] cost = {2, 7, 15};
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int minCost = target.mincostTickets(days, cost);
        // 17 = 15{1->30} + 2{31}
        assertEquals(17, minCost);
    }

    @Test
    public void testMinCostTickets3() {
        int[] cost = {2, 10, 41};
        int[] days = {6, 8, 9, 18, 20, 21, 23, 25};
        int minCost = target.mincostTickets(days, cost);
        // 16 = 2*8
        assertEquals(16, minCost);
    }
}