package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_SumOfElementsTest {

    _EX_SumOfElements target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_SumOfElements();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSumBetweenTwoKth1() throws Exception {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 3;
        int k2 = 6;
        int sum = target.sumBetweenTwoKth(arr, k1, k2);
        assertEquals(26, sum);
    }

    @Test
    public void testSumBetweenTwoKth2() throws Exception {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 1;
        int k2 = 7;
        int sum = target.sumBetweenTwoKth(arr, k1, k2);
        assertEquals(64, sum);
    }

    @Test
    public void testSumBetweenTwoKth3() throws Exception {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 4;
        int k2 = 6;
        int sum = target.sumBetweenTwoKth(arr, k1, k2);
        assertEquals(14, sum);
    }

    @Test
    public void testSumBetweenTwoKth4() throws Exception {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 5;
        int k2 = 6;
        int sum = target.sumBetweenTwoKth(arr, k1, k2);
        assertEquals(0, sum);
    }
}
