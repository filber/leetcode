package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _73_SetMatrixZeroesTest {

    _73_SetMatrixZeroes target = null;

    @Before
    public void before() throws Exception {
        target = new _73_SetMatrixZeroes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSetZeroes1() throws Exception {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        target.setZeroes(matrix);
        int[][] expected = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(expected[i], matrix[i]);
        }
    }

    @Test
    public void testSetZeroes2() throws Exception {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        target.setZeroes(matrix);
        int[][] expected = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(expected[i], matrix[i]);
        }
    }
}
