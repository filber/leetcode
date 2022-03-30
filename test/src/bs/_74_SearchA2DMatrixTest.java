package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _74_SearchA2DMatrixTest {

    _74_SearchA2DMatrix target = null;

    @Before
    public void before() throws Exception {
        target = new _74_SearchA2DMatrix();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSearchMatrix1() throws Exception {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        assertTrue(target.searchMatrix(matrix, 3));
        assertFalse(target.searchMatrix(matrix, 13));
        assertFalse(target.searchMatrix(matrix, 0));
        assertFalse(target.searchMatrix(matrix, 61));
    }

    @Test
    public void testSearchMatrix2() throws Exception {
        int[][] matrix = new int[][]{{1, 3, 5, 7}};
        assertTrue(target.searchMatrix(matrix, 3));
        assertFalse(target.searchMatrix(matrix, -1));
        assertFalse(target.searchMatrix(matrix, 10));
        assertFalse(target.searchMatrix(matrix, 4));
    }

    @Test
    public void testSearchMatrix3() throws Exception {
        int[][] matrix = new int[][]{{1}, {3}, {5}, {7}};
        assertTrue(target.searchMatrix(matrix, 3));
        assertFalse(target.searchMatrix(matrix, -1));
        assertFalse(target.searchMatrix(matrix, 10));
        assertFalse(target.searchMatrix(matrix, 4));
    }
}
