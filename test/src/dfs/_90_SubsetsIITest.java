package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _90_SubsetsIITest {

    _90_SubsetsII target = null;

    @Before
    public void before() throws Exception {
        target = new _90_SubsetsII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSubsetsWithDup1() throws Exception {
        List<List<Integer>> list = target.subsetsWithDup(new int[]{1, 2, 2});
        assertEquals(6, list.size());
    }

    @Test
    public void testSubsetsWithDup5() throws Exception {
        List<List<Integer>> list = target.subsetsWithDup(new int[]{2, 1, 2});
        assertEquals(6, list.size());
    }

    @Test
    public void testSubsetsWithDup2() throws Exception {
        List<List<Integer>> list = target.subsetsWithDup(new int[]{1, 2, 3});
        assertEquals(8, list.size());
    }

    @Test
    public void testSubsetsWithDup3() throws Exception {
        List<List<Integer>> list = target.subsetsWithDup(new int[]{0});
        assertEquals(2, list.size());
    }

    @Test
    public void testSubsetsWithDup4() throws Exception {
        List<List<Integer>> list = target.subsetsWithDup(new int[]{1, 1, 1, 1, 1, 1});
        assertEquals(7, list.size());
    }
}