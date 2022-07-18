package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1074_NumberOfSubmatricesThatSumToTargetTest {

    _1074_NumberOfSubmatricesThatSumToTarget target = null;

    @Before
    public void before() throws Exception {
        target = new _1074_NumberOfSubmatricesThatSumToTarget();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNumSubmatrixSumTarget1() throws Exception {
        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}};
        int t = 0;
        int count = target.numSubmatrixSumTarget(matrix, t);
        assertEquals(4, count);
    }

    @Test
    public void testNumSubmatrixSumTarget2() throws Exception {
        int[][] matrix = {
                {1, -1},
                {-1, 1}};
        int t = 0;
        int count = target.numSubmatrixSumTarget(matrix, t);
        assertEquals(5, count);
    }

    @Test
    public void testNumSubmatrixSumTarget3() throws Exception {
        int[][] matrix = {
                {904}};
        int t = 0;
        int count = target.numSubmatrixSumTarget(matrix, t);
        assertEquals(0, count);
    }
}
