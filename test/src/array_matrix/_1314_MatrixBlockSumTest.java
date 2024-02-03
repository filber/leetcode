package array_matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1314_MatrixBlockSumTest {

    _1314_MatrixBlockSum target;

    @Before
    public void setUp() throws Exception {
        target = new _1314_MatrixBlockSum();
    }

    @Test
    public void testMatrixBlockSum1() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int k = 1;
        int[][] actualOutput = target.matrixBlockSum(matrix, k);
        int[][] expectOutput = {
                {12, 21, 16},
                {27, 45, 33},
                {24, 39, 28},
        };
        assertEquals(expectOutput.length, actualOutput.length);
        for (int i = 0; i < expectOutput.length; i++) {
            assertArrayEquals(expectOutput[i], actualOutput[i]);
        }
    }

    @Test
    public void testMatrixBlockSum2() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int k = 2;
        int[][] actualOutput = target.matrixBlockSum(matrix, k);
        int[][] expectOutput = {
                {45, 45, 45},
                {45, 45, 45},
                {45, 45, 45},
        };
        assertEquals(expectOutput.length, actualOutput.length);
        for (int i = 0; i < expectOutput.length; i++) {
            assertArrayEquals(expectOutput[i], actualOutput[i]);
        }
    }

    @Test
    public void testMatrixBlockSum3() {
        int[][] matrix = new int[][]{
                {67, 64, 78},
                {82, 46, 46},
                {6, 52, 55},
                {55, 99, 45}};
        int k = 1;
        int[][] actualOutput = target.matrixBlockSum(matrix, k);
        int[][] expectOutput = {
                {259, 383, 234},
                {317, 496, 341},
                {340, 486, 343},
                {212, 312, 251}
        };
        assertEquals(expectOutput.length, actualOutput.length);
        for (int i = 0; i < expectOutput.length; i++) {
            assertArrayEquals(expectOutput[i], actualOutput[i]);
        }
    }
}