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
        int t = 3;
        int ways = target.findTargetSumWays(nums, t);
        assertEquals(5, ways);
    }
}
