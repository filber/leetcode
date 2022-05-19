package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _77_CombinationsTest {

    _77_Combinations target = null;

    @Before
    public void before() throws Exception {
        target = new _77_Combinations();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCombine1() throws Exception {
        List<List<Integer>> list = target.combine(4, 2);
        assertEquals(6, list.size());
    }

    @Test
    public void testCombine2() throws Exception {
        List<List<Integer>> list = target.combine(1, 1);
        assertEquals(1, list.size());
    }

    @Test
    public void testCombine3() throws Exception {
        List<List<Integer>> list = target.combine(2, 2);
        assertEquals(1, list.size());
    }

    @Test
    public void testCombine4() throws Exception {
        List<List<Integer>> list = target.combine(10, 3);
        assertEquals(120, list.size());
    }
}
