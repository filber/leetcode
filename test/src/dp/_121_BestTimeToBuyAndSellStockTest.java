package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _121_BestTimeToBuyAndSellStockTest {

    _121_BestTimeToBuyAndSellStock target;

    @Before
    public void setUp() throws Exception {
        target = new _121_BestTimeToBuyAndSellStock();
    }

    @Test
    public void testMaxProfit1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = target.maxProfit(prices);
        assertEquals(5, profit); // 1->6
    }

    @Test
    public void testMaxProfit2() {
        int[] prices = {7, 6, 4, 3, 1};
        int profit = target.maxProfit(prices);
        assertEquals(0, profit);
    }

    @Test
    public void testMaxProfit3() {
        int[] prices = {3};
        int profit = target.maxProfit(prices);
        assertEquals(0, profit);
    }
}