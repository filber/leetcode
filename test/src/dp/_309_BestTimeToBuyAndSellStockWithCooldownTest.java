package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _309_BestTimeToBuyAndSellStockWithCooldownTest {

    _309_BestTimeToBuyAndSellStockWithCooldown target;

    @Before
    public void init() {
        target = new _309_BestTimeToBuyAndSellStockWithCooldown();
    }

    @Test
    public void testMaxProfit1() {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        int profit = target.maxProfit(prices);
        // buy(1)->sell(2)->cooldown->buy(0)->sell(2)
        assertEquals(3, profit);
    }

    @Test
    public void testMaxProfit2() {
        int[] prices = new int[]{1};
        int profit = target.maxProfit(prices);
        assertEquals(0, profit);
    }
}