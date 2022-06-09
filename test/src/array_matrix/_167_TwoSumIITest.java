package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _167_TwoSumIITest {

    _167_TwoSumII target = null;

    @Before
    public void before() throws Exception {
        target = new _167_TwoSumII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTwoSum1() throws Exception {
        int[] pair = target.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{1, 2}, pair);
    }

    @Test
    public void testTwoSum2() throws Exception {
        int[] pair = target.twoSum(new int[]{2, 3, 4}, 6);
        assertArrayEquals(new int[]{1, 3}, pair);
    }

    @Test
    public void testTwoSum3() throws Exception {
        int[] pair = target.twoSum(new int[]{-1, 0}, -1);
        assertArrayEquals(new int[]{1, 2}, pair);
    }
}
