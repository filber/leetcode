package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _786_KthSmallestPrimeFractionTest {

    _786_KthSmallestPrimeFraction target = null;

    @Before
    public void before() throws Exception {
        target = new _786_KthSmallestPrimeFraction();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testKthSmallestPrimeFraction1() throws Exception {
        int[] arr = {1, 2, 3, 5};
        assertArrayEquals(new int[]{1, 5}, target.kthSmallestPrimeFraction(arr, 1));
        assertArrayEquals(new int[]{1, 3}, target.kthSmallestPrimeFraction(arr, 2));
        assertArrayEquals(new int[]{2, 5}, target.kthSmallestPrimeFraction(arr, 3));
        assertArrayEquals(new int[]{1, 2}, target.kthSmallestPrimeFraction(arr, 4));
        assertArrayEquals(new int[]{3, 5}, target.kthSmallestPrimeFraction(arr, 5));
        assertArrayEquals(new int[]{2, 3}, target.kthSmallestPrimeFraction(arr, 6));
    }

    @Test
    public void testKthSmallestPrimeFraction2() throws Exception {
        int[] arr = {1, 7};
        assertArrayEquals(new int[]{1, 7}, target.kthSmallestPrimeFraction(arr, 1));
    }
}
