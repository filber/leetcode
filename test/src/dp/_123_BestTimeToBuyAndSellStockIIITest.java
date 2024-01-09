package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _123_BestTimeToBuyAndSellStockIIITest {

    _123_BestTimeToBuyAndSellStockIII target;

    @Before
    public void init() {
        target = new _123_BestTimeToBuyAndSellStockIII();
    }

    @Test
    public void testMaxProfit1() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        // 3->5=2; 0->4=4;
        int profit = target.maxProfit(prices);
        assertEquals(6, profit);
    }

    @Test
    public void testMaxProfit2() {
        int[] prices = {1, 2, 3, 4, 5};
        // 1->2=1; 2->5=3;
        int profit = target.maxProfit(prices);
        assertEquals(4, profit);
    }

    @Test
    public void testMaxProfit3() {
        int[] prices = {7, 6, 4, 3, 1};
        int profit = target.maxProfit(prices);
        assertEquals(0, profit);
    }

    @Test
    public void testMaxProfit4() {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int profit = target.maxProfit(prices);
        // 1->7=6; 2->9=7
        assertEquals(13, profit);
    }
}