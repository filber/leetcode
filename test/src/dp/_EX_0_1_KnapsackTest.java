package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_0_1_KnapsackTest {

    _EX_0_1_Knapsack target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_0_1_Knapsack();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testKnapsack1() throws Exception {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;
        int largestValue = target.knapsack(capacity, weight, value);
        assertEquals(220, largestValue);
    }

    @Test
    public void testKnapsack2() throws Exception {
        int[] value = {10, 15, 40};
        int[] weight = {1, 2, 3};
        int capacity = 6;
        int largestValue = target.knapsack(capacity, weight, value);
        assertEquals(65, largestValue);
    }
}
