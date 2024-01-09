package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _188_BestTimeToBuyAndSellStockIVTest {

    _188_BestTimeToBuyAndSellStockIV target;

    @Before
    public void setUp() {
        target = new _188_BestTimeToBuyAndSellStockIV();
    }

    @Test
    public void testMaxProfit1() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;
        int profit = target.maxProfit(k, prices);
        assertEquals(6, profit);
    }

    @Test
    public void testMaxProfit2() {
        int[] prices = {1, 2, 3, 4, 5};
        int k = 2;
        int profit = target.maxProfit(k, prices);
        assertEquals(4, profit);
    }

    @Test
    public void testMaxProfit3() {
        int[] prices = {7, 6, 4, 3, 1};
        int k = 2;
        int profit = target.maxProfit(k, prices);
        assertEquals(0, profit);
    }

    @Test
    public void testMaxProfit4() {
        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int k = 2;
        int profit = target.maxProfit(k, prices);
        assertEquals(13, profit);
    }

    @Test
    public void testMaxProfit5() {
        int[] prices = {2, 4, 1};
        int k = 2;
        int profit = target.maxProfit(k, prices);
        assertEquals(2, profit);
    }

    @Test
    public void testMaxProfit6() {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        int profit = target.maxProfit(k, prices);
        assertEquals(7, profit);
    }
}