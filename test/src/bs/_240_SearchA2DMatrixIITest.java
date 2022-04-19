package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _240_SearchA2DMatrixIITest {

    _240_SearchA2DMatrixII target = null;

    @Before
    public void before() throws Exception {
        target = new _240_SearchA2DMatrixII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSearchMatrix1() throws Exception {
        int[][] matrix = new int[][]{
                {1}};
        assertTrue(target.searchMatrix(matrix, 1));
        assertFalse(target.searchMatrix(matrix, 2));
    }

    @Test
    public void testSearchMatrix2() throws Exception {
        int[][] matrix = new int[][]{
                {1, 2}, {3, 4}};
        assertTrue(target.searchMatrix(matrix, 2));
        assertFalse(target.searchMatrix(matrix, 5));
    }

    @Test
    public void testSearchMatrix3() throws Exception {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15}};
        assertTrue(target.searchMatrix(matrix, 4));
        assertFalse(target.searchMatrix(matrix, 20));
    }

    @Test
    public void testSearchMatrix4() throws Exception {
        int[][] matrix = new int[][]{
                {1}, {4}, {7}, {11}, {15}
        };
        assertTrue(target.searchMatrix(matrix, 11));
        assertFalse(target.searchMatrix(matrix, 20));
    }

    @Test
    public void testSearchMatrix5() throws Exception {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertTrue(target.searchMatrix(matrix, 5));
        assertFalse(target.searchMatrix(matrix, 20));
        assertFalse(target.searchMatrix(matrix, 0));
        assertFalse(target.searchMatrix(matrix, 31));
        assertTrue(target.searchMatrix(matrix, 1));
        assertTrue(target.searchMatrix(matrix, 15));
        assertTrue(target.searchMatrix(matrix, 18));
        assertTrue(target.searchMatrix(matrix, 30));
        assertTrue(target.searchMatrix(matrix, 3));
        assertTrue(target.searchMatrix(matrix, 11));
        assertTrue(target.searchMatrix(matrix, 23));
        assertTrue(target.searchMatrix(matrix, 22));
    }
}
