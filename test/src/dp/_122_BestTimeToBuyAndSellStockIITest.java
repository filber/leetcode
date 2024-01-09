package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _122_BestTimeToBuyAndSellStockIITest {

    _122_BestTimeToBuyAndSellStockII target;

    @Before
    public void init() {
        target = new _122_BestTimeToBuyAndSellStockII();
    }

    @Test
    public void testMaxProfit1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = target.maxProfit(prices);
        // 1->5=4, 3->6=3
        assertEquals(7, profit);
    }

    @Test
    public void testMaxProfit2() {
        int[] prices = {1, 2, 3, 4, 5};
        int profit = target.maxProfit(prices);
        // 1->2, 2->3, 3->4, 4->5 OR 1->5
        assertEquals(4, profit);
    }

    @Test
    public void testMaxProfit3() {
        int[] prices = {7, 6, 4, 3, 1};
        int profit = target.maxProfit(prices);
        assertEquals(0, profit);
    }
}