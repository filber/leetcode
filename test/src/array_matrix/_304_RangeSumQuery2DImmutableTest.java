package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import array_matrix._304_RangeSumQuery2DImmutable.NumMatrix;

import static org.junit.Assert.*;

public class _304_RangeSumQuery2DImmutableTest {

    _304_RangeSumQuery2DImmutable target = null;

    @Before
    public void before() throws Exception {
        target = new _304_RangeSumQuery2DImmutable();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSumRegion1() throws Exception {
        int[][] m = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix matrix = new NumMatrix(m);

        int s1 = matrix.sumRegion(2, 1, 4, 3);
        assertEquals(8, s1);
        int s2 = matrix.sumRegion(1, 1, 2, 2);
        assertEquals(11, s2);
        int s3 = matrix.sumRegion(1, 2, 2, 4);
        assertEquals(12, s3);

        int s4 = matrix.sumRegion(3, 0, 3, 0);
        assertEquals(4, s4);

        int s5 = matrix.sumRegion(0, 0, 0, 4);
        assertEquals(10, s5);
        int s6 = matrix.sumRegion(0, 0, 4, 0);
        assertEquals(14, s6);
    }
} 
