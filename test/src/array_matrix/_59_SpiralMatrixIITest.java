package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _59_SpiralMatrixIITest {

    _59_SpiralMatrixII target = null;

    @Before
    public void before() throws Exception {
        target = new _59_SpiralMatrixII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGenerateMatrix1() throws Exception {
        int[][] m = target.generateMatrix(1);
        assertArrayEquals(new int[]{1}, m[0]);
    }

    @Test
    public void testGenerateMatrix2() throws Exception {
        int[][] m = target.generateMatrix(2);
        assertArrayEquals(new int[]{1, 2}, m[0]);
        assertArrayEquals(new int[]{4, 3}, m[1]);
    }

    @Test
    public void testGenerateMatrix3() throws Exception {
        int[][] m = target.generateMatrix(3);
        assertArrayEquals(new int[]{1, 2, 3}, m[0]);
        assertArrayEquals(new int[]{8, 9, 4}, m[1]);
        assertArrayEquals(new int[]{7, 6, 5}, m[2]);
    }

    @Test
    public void testGenerateMatrix4() throws Exception {
        int[][] m = target.generateMatrix(4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, m[0]);
        assertArrayEquals(new int[]{12, 13, 14, 5}, m[1]);
        assertArrayEquals(new int[]{11, 16, 15, 6}, m[2]);
        assertArrayEquals(new int[]{10, 9, 8, 7}, m[3]);
    }

    @Test
    public void testGenerateMatrix5() throws Exception {
        int[][] m = target.generateMatrix(5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, m[0]);
        assertArrayEquals(new int[]{16, 17, 18, 19, 6}, m[1]);
        assertArrayEquals(new int[]{15, 24, 25, 20, 7}, m[2]);
        assertArrayEquals(new int[]{14, 23, 22, 21, 8}, m[3]);
        assertArrayEquals(new int[]{13, 12, 11, 10, 9}, m[4]);
    }
}
