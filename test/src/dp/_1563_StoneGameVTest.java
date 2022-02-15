package dp;

import dp._1563_StoneGameV;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1563_StoneGameVTest {

    _1563_StoneGameV target = null;

    @Before
    public void before() throws Exception {
        target = new _1563_StoneGameV();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testStoneGameV1() throws Exception {
        int score = target.stoneGameV(new int[]{6, 2, 3, 4, 5, 5});
        assertEquals(18, score);
    }

    @Test
    public void testStoneGameV2() throws Exception {
        int score = target.stoneGameV(new int[]{7, 7, 7, 7, 7, 7, 7});
        assertEquals(28, score);
    }

    @Test
    public void testStoneGameV4() throws Exception {
        int score = target.stoneGameV(new int[]{7, 7, 7});
        assertEquals(7, score);
    }

    @Test
    public void testStoneGameV3() throws Exception {
        int score = target.stoneGameV(new int[]{4});
        assertEquals(0, score);
    }
}
