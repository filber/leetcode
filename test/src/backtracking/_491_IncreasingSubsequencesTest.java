package backtracking;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _491_IncreasingSubsequencesTest {

    _491_IncreasingSubsequences target = null;

    @Before
    public void before() throws Exception {
        target = new _491_IncreasingSubsequences();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindSubsequences1() throws Exception {
        List<List<Integer>> list = target.findSubsequences(new int[]{4, 6, 7, 7});
        assertEquals(8, list.size());
    }

    @Test
    public void testFindSubsequences2() throws Exception {
        List<List<Integer>> list = target.findSubsequences(new int[]{4, 4, 3, 2, 1});
        assertEquals(1, list.size());
    }

    @Test
    public void testFindSubsequences3() throws Exception {
        List<List<Integer>> list = target.findSubsequences(new int[]{1, 2});
        assertEquals(1, list.size());
    }

    @Test
    public void testFindSubsequences4() throws Exception {
        List<List<Integer>> list = target.findSubsequences(new int[]{1, 2, 3});
        assertEquals(4, list.size());
    }

    @Test
    public void testFindSubsequences5() throws Exception {
        List<List<Integer>> list = target.findSubsequences(new int[]{1, 2, 2});
        assertEquals(3, list.size());
    }

    @Test
    public void testFindSubsequences6() throws Exception {
        List<List<Integer>> list = target.findSubsequences(new int[]{1, 1, 1});
        assertEquals(2, list.size());
    }
}
