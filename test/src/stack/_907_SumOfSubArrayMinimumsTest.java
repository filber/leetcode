package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _907_SumOfSubArrayMinimumsTest {

    _907_SumOfSubArrayMinimums target = null;

    @Before
    public void before() throws Exception {
        target = new _907_SumOfSubArrayMinimums();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSumSubarrayMins1() throws Exception {
        int[] arr = {3, 2, 1, 4};
        int sum = target.sumSubarrayMins(arr);
        assertEquals(17, sum);
    }

    @Test
    public void testSumSubarrayMins2() throws Exception {
        int[] arr = {11, 81, 94, 43, 3};
        int sum = target.sumSubarrayMins(arr);
        assertEquals(444, sum);
    }

    @Test
    public void testSumSubarrayMins3() throws Exception {
        int[] arr = {71, 55, 82, 55};
        int sum = target.sumSubarrayMins(arr);
        assertEquals(593, sum);
    }
}
