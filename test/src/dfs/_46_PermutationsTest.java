package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _46_PermutationsTest {

    _46_Permutations target = null;

    @Before
    public void before() throws Exception {
        target = new _46_Permutations();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testPermute1() throws Exception {
        List<List<Integer>> list = target.permute(new int[]{1, 2, 3});
        assertEquals(6, list.size());
    }

    @Test
    public void testPermute2() throws Exception {
        List<List<Integer>> list = target.permute(new int[]{1, 2});
        assertEquals(2, list.size());
    }

    @Test
    public void testPermute3() throws Exception {
        List<List<Integer>> list = target.permute(new int[]{1});
        assertEquals(1, list.size());
    }

    @Test
    public void testPermute4() throws Exception {
        List<List<Integer>> list = target.permute(new int[]{1, 2, 3, 4});
        assertEquals(24, list.size());
    }

    @Test
    public void testPermute5() throws Exception {
        List<List<Integer>> list = target.permute(new int[]{1, 2, 3, 4, 5});
        assertEquals(120, list.size());
    }

    @Test
    public void testPermute6() throws Exception {
        List<List<Integer>> list = target.permute(new int[]{1, 2, 3, 4, 5, 6});
        assertEquals(720, list.size());
    }
} 
