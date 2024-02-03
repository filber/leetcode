package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1043_PartitionArrayForMaximumSumTest {

    _1043_PartitionArrayForMaximumSum target;

    @Before
    public void setUp() throws Exception {
        target = new _1043_PartitionArrayForMaximumSum();
    }

    @Test
    public void testMaxSumAfterPartitioning1() {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int sum = target.maxSumAfterPartitioning(arr, k);
        // [15,15,15,9,10,10,10]
        assertEquals(84, sum);
    }

    @Test
    public void testMaxSumAfterPartitioning2() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int sum = target.maxSumAfterPartitioning(arr, k);
        assertEquals(83, sum);
    }

    @Test
    public void testMaxSumAfterPartitioning3() {
        int[] arr = {1};
        int k = 1;
        int sum = target.maxSumAfterPartitioning(arr, k);
        assertEquals(1, sum);
    }
}