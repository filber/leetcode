package bfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _407_TrappingRainWaterIITest {

    _407_TrappingRainWaterII target = null;

    @Before
    public void before() throws Exception {
        target = new _407_TrappingRainWaterII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTrapRainWater1() throws Exception {
        int volume = target.trapRainWater(new int[][]{
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        });
        assertEquals(4, volume);
    }

    @Test
    public void testTrapRainWater2() throws Exception {
        int volume = target.trapRainWater(new int[][]{
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3}
        });
        assertEquals(10, volume);
    }

    @Test
    public void testTrapRainWater3() throws Exception {
        int volume = target.trapRainWater(new int[][]{
                {12, 13, 1, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}
        });
        assertEquals(14, volume);
    }
}
