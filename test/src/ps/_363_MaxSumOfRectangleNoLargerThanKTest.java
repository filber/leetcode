package ps;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _363_MaxSumOfRectangleNoLargerThanKTest {

    _363_MaxSumOfRectangleNoLargerThanK target;

    @Before
    public void before() throws Exception {
        target = new _363_MaxSumOfRectangleNoLargerThanK();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaxSumSubmatrix1() throws Exception {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        int maxSum = target.maxSumSubmatrix(matrix, k);
        assertEquals(2, maxSum);
    }

    @Test
    public void testMaxSumSubmatrix2() throws Exception {
        int[][] matrix = {{2,2,-1}};
        int k = 3;
        int maxSum = target.maxSumSubmatrix(matrix, k);
        assertEquals(3, maxSum);
    }
}
