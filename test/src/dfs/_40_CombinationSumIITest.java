package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _40_CombinationSumIITest {

    _40_CombinationSumII target = null;

    @Before
    public void before() throws Exception {
        target = new _40_CombinationSumII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCombinationSum1() throws Exception {
        List<List<Integer>> list = target.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        assertEquals(4, list.size());
        assertArrayEquals(new Integer[]{1, 1, 6}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 2, 5}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 7}, list.get(2).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 6}, list.get(3).toArray(new Integer[0]));
    }

    @Test
    public void testCombinationSum2() throws Exception {
        List<List<Integer>> list = target.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        assertEquals(2, list.size());
        assertArrayEquals(new Integer[]{1, 2, 2}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{5}, list.get(1).toArray(new Integer[0]));
    }

    @Test
    public void testCombinationSum3() throws Exception {
        List<List<Integer>> list = target.combinationSum2(new int[]{10}, 8);
        assertEquals(0, list.size());
    }
}
