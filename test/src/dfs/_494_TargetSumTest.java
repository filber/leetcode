package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _494_TargetSumTest {

    _494_TargetSum target = null;

    @Before
    public void before() throws Exception {
        target = new _494_TargetSum();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindTargetSumWays1() throws Exception {
        int[] nums = {1, 1, 1, 1, 1};
        assertEquals(5, target.findTargetSumWays(nums, 3));
        assertEquals(10, target.findTargetSumWays(nums, 1));
        assertEquals(0, target.findTargetSumWays(nums, 0));
    }

    @Test
    public void testFindTargetSumWays2() throws Exception {
        int[] nums = {100};
        assertEquals(0, target.findTargetSumWays(nums, -200));
    }

    @Test
    public void testFindTargetSumWays3() throws Exception {
        int[] nums = {1};
        assertEquals(1, target.findTargetSumWays(nums, 1));
    }

    @Test
    public void testFindTargetSumWays4() throws Exception {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        assertEquals(256, target.findTargetSumWays(nums, 1));
    }

    @Test
    public void testFindTargetSumWays5() throws Exception {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        assertEquals(0, target.findTargetSumWays(nums, 0));
    }

    @Test
    public void testFindTargetSumWays6() throws Exception {
        int[] nums = {1, 0};
        assertEquals(2, target.findTargetSumWays(nums, 1));
    }
}
