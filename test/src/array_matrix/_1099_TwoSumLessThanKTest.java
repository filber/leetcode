package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1099_TwoSumLessThanKTest {

    _1099_TwoSumLessThanK target = null;

    @Before
    public void before() throws Exception {
        target = new _1099_TwoSumLessThanK();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTwoSumLessThanK1() throws Exception {
        int[] A = {34, 23, 1, 24, 75, 33, 54, 8};
        int K = 60;
        // 58 = 34 + 24
        int sum = target.twoSumLessThanK(A, K);
        assertEquals(58, sum);
    }

    @Test
    public void testTwoSumLessThanK2() throws Exception {
        int[] A = {10, 20, 30};
        int K = 15;
        int sum = target.twoSumLessThanK(A, K);
        assertEquals(-1, sum);
    }
}
