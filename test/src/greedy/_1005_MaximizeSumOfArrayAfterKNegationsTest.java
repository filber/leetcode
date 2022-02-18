package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1005_MaximizeSumOfArrayAfterKNegationsTest {

    _1005_MaximizeSumOfArrayAfterKNegations target = null;

    @Before
    public void before() throws Exception {
        target = new _1005_MaximizeSumOfArrayAfterKNegations();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLargestSumAfterKNegations1() throws Exception {
        int sum = target.largestSumAfterKNegations(new int[]{4, 2, 3}, 1);
        assertEquals(5, sum);
    }

    @Test
    public void testLargestSumAfterKNegations2() throws Exception {
        int sum = target.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        assertEquals(6, sum);
    }

    @Test
    public void testLargestSumAfterKNegations3() throws Exception {
        int sum = target.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
        assertEquals(13, sum);
    }

    @Test
    public void testLargestSumAfterKNegations4() throws Exception {
        int sum = target.largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6);
        assertEquals(22, sum);
    }

    @Test
    public void testLargestSumAfterKNegations5() throws Exception {
        int sum = target.largestSumAfterKNegations(new int[]{-4, -2, -3}, 4);
        assertEquals(5, sum);
    }
}
