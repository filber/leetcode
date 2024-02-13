package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _486_PredictTheWinnerTest {

    _486_PredictTheWinner target;

    @Before
    public void setUp() throws Exception {
        target = new _486_PredictTheWinner();
    }

    @Test
    public void testPredictTheWinner1() {
        int[] nums = {1, 5, 2};
        boolean win = target.predictTheWinner(nums);
        assertFalse(win);
    }

    @Test
    public void testPredictTheWinner2() {
        int[] nums = {1, 5, 233, 7};
        boolean win = target.predictTheWinner(nums);
        assertTrue(win);
    }
}