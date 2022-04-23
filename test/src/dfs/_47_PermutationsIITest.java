package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _47_PermutationsIITest {

    _47_PermutationsII target = null;

    @Before
    public void before() throws Exception {
        target = new _47_PermutationsII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPermuteUnique1() throws Exception {
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = target.permuteUnique(nums);

        assertEquals(3, list.size());
        assertArrayEquals(new Integer[]{1, 1, 2}, list.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{1, 2, 1}, list.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{2, 1, 1}, list.get(2).toArray(new Integer[0]));
    }

    @Test
    public void testPermuteUnique2() throws Exception {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = target.permuteUnique(nums);

        assertEquals(6, list.size());
    }

    @Test
    public void testPermuteUnique3() throws Exception {
        int[] nums = {1, 1, 1, 2};
        List<List<Integer>> list = target.permuteUnique(nums);

        assertEquals(4, list.size());
    }
}
