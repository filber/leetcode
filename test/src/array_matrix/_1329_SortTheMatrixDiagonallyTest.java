package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1329_SortTheMatrixDiagonallyTest {

    _1329_SortTheMatrixDiagonally target = null;

    @Before
    public void before() throws Exception {
        target = new _1329_SortTheMatrixDiagonally();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDiagonalSort1() throws Exception {
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] sortedMat = target.diagonalSort(mat);
        int[][] expected = {{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}};
        for (int i = 0; i < mat.length; i++) {
            assertArrayEquals(expected[i], sortedMat[i]);
        }
    }

    @Test
    public void testDiagonalSort2() throws Exception {
        int[][] mat = {{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
        int[][] sortedMat = target.diagonalSort(mat);
        int[][] expected = {{5, 17, 4, 1, 52, 7}, {11, 11, 25, 45, 8, 69}, {14, 23, 25, 44, 58, 15}, {22, 27, 31, 36, 50, 66}, {84, 28, 75, 33, 55, 68}};
        for (int i = 0; i < mat.length; i++) {
            assertArrayEquals(expected[i], sortedMat[i]);
        }
    }
}
