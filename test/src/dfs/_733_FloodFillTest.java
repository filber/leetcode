package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _733_FloodFillTest {

    _733_FloodFill target = null;

    @Before
    public void before() throws Exception {
        target = new _733_FloodFill();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFloodFill1() throws Exception {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] coloredImg = target.floodFill(image, sr, sc, color);
        assertEquals(3, coloredImg.length);
        assertArrayEquals(new int[]{2, 2, 2}, coloredImg[0]);
        assertArrayEquals(new int[]{2, 2, 0}, coloredImg[1]);
        assertArrayEquals(new int[]{2, 0, 1}, coloredImg[2]);
    }

    @Test
    public void testFloodFill2() throws Exception {
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int sr = 0;
        int sc = 0;
        int color = 0;
        int[][] coloredImg = target.floodFill(image, sr, sc, color);
        assertEquals(2, coloredImg.length);
        assertArrayEquals(new int[]{0, 0, 0}, coloredImg[0]);
        assertArrayEquals(new int[]{0, 0, 0}, coloredImg[1]);
    }
}
