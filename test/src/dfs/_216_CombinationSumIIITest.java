package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _216_CombinationSumIIITest {

    _216_CombinationSumIII target = null;

    @Before
    public void before() throws Exception {
        target = new _216_CombinationSumIII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCombinationSum1() throws Exception {
        List<List<Integer>> list = target.combinationSum3(3, 7);
        assertEquals(1, list.size());
        assertArrayEquals(new Integer[]{1, 2, 4}, list.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testCombinationSum2() throws Exception {
        List<List<Integer>> list = target.combinationSum3(3, 9);
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[]{1, 2, 6}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 3, 5}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 3, 4}, list.get(2).toArray(new Integer[0]));
    }

    @Test
    public void testCombinationSum3() throws Exception {
        List<List<Integer>> list = target.combinationSum3(4, 1);
        assertTrue(list.isEmpty());
    }
}
