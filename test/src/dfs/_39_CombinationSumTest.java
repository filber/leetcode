package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _39_CombinationSumTest {

    _39_CombinationSum target = null;

    @Before
    public void before() throws Exception {
        target = new _39_CombinationSum();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCombinationSum1() throws Exception {
        List<List<Integer>> list = target.combinationSum(new int[]{2, 3, 6, 7}, 7);
        assertEquals(2, list.size());
        assertArrayEquals(new Integer[]{2, 2, 3}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{7}, list.get(1).toArray(new Integer[0]));
    }

    @Test
    public void testCombinationSum2() throws Exception {
        List<List<Integer>> list = target.combinationSum(new int[]{2, 3, 5}, 8);
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[]{2, 2, 2, 2}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 3, 3}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{3, 5}, list.get(2).toArray(new Integer[0]));
    }

    @Test
    public void testCombinationSum3() throws Exception {
        List<List<Integer>> list = target.combinationSum(new int[]{2}, 1);
        assertEquals(0, list.size());
    }

    @Test
    public void testCombinationSum4() throws Exception {
        List<List<Integer>> list = target.combinationSum(new int[]{1}, 1);
        assertEquals(Integer.valueOf(1), list.get(0).get(0));
    }
}
