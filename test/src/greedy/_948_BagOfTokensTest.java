package greedy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _948_BagOfTokensTest {

    _948_BagOfTokens target;

    @Before
    public void setUp() throws Exception {
        target = new _948_BagOfTokens();
    }

    @Test
    public void testBagOfTokensScore1() {
        int[] tokens = {100};
        int power = 50;
        int score = target.bagOfTokensScore(tokens, power);
        assertEquals(0, score);
    }

    @Test
    public void testBagOfTokensScore2() {
        int[] tokens = {200, 100};
        int power = 150;
        int score = target.bagOfTokensScore(tokens, power);
        assertEquals(1, score);
    }

    @Test
    public void testBagOfTokensScore3() {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        int score = target.bagOfTokensScore(tokens, power);
        assertEquals(2, score);
    }

    @Test
    public void testBagOfTokensScore4() {
        int[] tokens = {};
        int power = 200;
        int score = target.bagOfTokensScore(tokens, power);
        assertEquals(0, score);
    }
}