package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _322_CoinChangeTest {

    _322_CoinChange target;

    @Before
    public void setUp() throws Exception {
        target = new _322_CoinChange();
    }

    @Test
    public void testCoinChange1() {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int ways = target.coinChange(coins, amount);
        // 3 {5+5+1}
        assertEquals(3, ways);
    }

    @Test
    public void testCoinChange2() {
        int[] coins = new int[]{2};
        int amount = 3;
        int ways = target.coinChange(coins, amount);
        // no way
        assertEquals(-1, ways);
    }

    @Test
    public void testCoinChange3() {
        int[] coins = new int[]{1};
        int amount = 0;
        int ways = target.coinChange(coins, amount);
        // no coin
        assertEquals(0, ways);
    }

    @Test
    public void testCoinChange4() {
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        int ways = target.coinChange(coins, amount);
        // no coin
        assertEquals(20, ways);
    }
}