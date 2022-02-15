package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1140_StoneGameIITest {

    _1140_StoneGameII target = null;

    @Before
    public void before() throws Exception {
        target = new _1140_StoneGameII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testStoneGameII1() throws Exception {
        // 104 [1+3+100]
        int score = target.stoneGameII(new int[]{1, 2, 3, 4, 5, 100});
        assertEquals(104, score);
    }

    @Test
    public void testStoneGameII2() throws Exception {
        // 10 [2+4+4]
        int score = target.stoneGameII(new int[]{2, 7, 9, 4, 4});
        assertEquals(10, score);
    }

    @Test
    public void testStoneGameII3() throws Exception {
        // 2 [1+1]
        int score = target.stoneGameII(new int[]{1, 1, 1});
        assertEquals(2, score);
    }

    @Test
    public void testStoneGameII6() throws Exception {
        // 1
        int score = target.stoneGameII(new int[]{1});
        assertEquals(1, score);
    }

    @Test
    public void testStoneGameII5() throws Exception {
        // 3
        int score = target.stoneGameII(new int[]{1,2});
        assertEquals(3, score);
    }

    @Test
    public void testStoneGameII4() throws Exception {
        // 217
        int score = target.stoneGameII(new int[]{77, 12, 64, 35, 28, 4, 87, 21, 20});
        assertEquals(217, score);
    }
}
