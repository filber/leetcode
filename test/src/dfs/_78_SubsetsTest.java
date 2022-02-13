package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _78_SubsetsTest {

    _78_Subsets target = null;

    @Before
    public void before() throws Exception {
        target = new _78_Subsets();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testOne() throws Exception {
        List list = target.subsets(new int[]{0});
        assertEquals(2, list.size());
    }

    @Test
    public void testTwo() throws Exception {
        List list = target.subsets(new int[]{1, 2});
        assertEquals(4, list.size());
    }

    @Test
    public void testThree() throws Exception {
        List list = target.subsets(new int[]{1, 2, 3});
        assertEquals(8, list.size());
    }


    @Test
    public void testFive() throws Exception {
        List list = target.subsets(new int[]{-1, 0, 1, 2, 3});
        assertEquals(32, list.size());
    }

    @Test
    public void testTen() throws Exception {
        List list = target.subsets(new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4});
        assertEquals(1024, list.size());
    }
}
