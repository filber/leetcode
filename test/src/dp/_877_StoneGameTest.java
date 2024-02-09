package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _877_StoneGameTest {

    _877_StoneGame target;

    @Before
    public void setUp() throws Exception {
        target = new _877_StoneGame();
    }

    @Test
    public void testStoneGame1() {
        boolean result = target.stoneGame(new int[]{5, 3, 4, 5});
        assertTrue(result);
    }

    @Test
    public void testStoneGame2() {
        boolean result = target.stoneGame(new int[]{3, 7, 2, 3});
        assertTrue(result);
    }

    @Test
    public void testStoneGame3() {
        boolean result = target.stoneGame(new int[]{7, 8, 8, 10});
        assertTrue(result);
    }
}