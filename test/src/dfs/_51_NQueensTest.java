package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _51_NQueensTest {

    _51_NQueens target = null;

    @Before
    public void before() throws Exception {
        target = new _51_NQueens();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSolveNQueens1() throws Exception {
        List<List<String>> ans = target.solveNQueens(1);
        assertEquals(1, ans.size());
        assertEquals(1, ans.get(0).size());
        assertEquals("Q", ans.get(0).get(0));
    }

    @Test
    public void testSolveNQueens2() throws Exception {
        List<List<String>> ans = target.solveNQueens(2);
        assertTrue(ans.isEmpty());
    }

    @Test
    public void testSolveNQueens3() throws Exception {
        List<List<String>> ans = target.solveNQueens(3);
        assertTrue(ans.isEmpty());
    }

    @Test
    public void testSolveNQueens4() throws Exception {
        List<List<String>> ans = target.solveNQueens(4);
        assertEquals(2, ans.size());
        assertArrayEquals(new String[]{".Q..", "...Q", "Q...", "..Q."}, ans.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"..Q.", "Q...", "...Q", ".Q.."}, ans.get(1).toArray(new String[0]));
    }
}
