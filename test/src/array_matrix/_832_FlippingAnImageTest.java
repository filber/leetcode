package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _832_FlippingAnImageTest {

    _832_FlippingAnImage target = null;

    @Before
    public void before() throws Exception {
        target = new _832_FlippingAnImage();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFlipAndInvertImage1() throws Exception {
        int[][] image = new int[][]{
                {1}
        };
        int[][] res = target.flipAndInvertImage(image);
        assertEquals(0, res[0][0]);
    }

    @Test
    public void testFlipAndInvertImage2() throws Exception {
        int[][] image = new int[][]{
                {0}
        };
        int[][] res = target.flipAndInvertImage(image);
        assertEquals(1, res[0][0]);
    }

    @Test
    public void testFlipAndInvertImage3() throws Exception {
        int[][] image = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] res = target.flipAndInvertImage(image);
        assertArrayEquals(new int[]{1, 0, 0}, res[0]);
        assertArrayEquals(new int[]{0, 1, 0}, res[1]);
        assertArrayEquals(new int[]{1, 1, 1}, res[2]);
    }

    @Test
    public void testFlipAndInvertImage4() throws Exception {
        int[][] image = new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        int[][] res = target.flipAndInvertImage(image);
        assertArrayEquals(new int[]{1, 1, 0, 0}, res[0]);
        assertArrayEquals(new int[]{0, 1, 1, 0}, res[1]);
        assertArrayEquals(new int[]{0, 0, 0, 1}, res[2]);
        assertArrayEquals(new int[]{1, 0, 1, 0}, res[3]);
    }
}
