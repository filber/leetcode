package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _48_RotateImageTest {

    _48_RotateImage target = null;

    @Before
    public void before() throws Exception {
        target = new _48_RotateImage();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRotate1() throws Exception {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotated = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        target.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(rotated[i], matrix[i]);
        }
    }

    @Test
    public void testRotate2() throws Exception {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] rotated = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        target.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(rotated[i], matrix[i]);
        }
    }
}
