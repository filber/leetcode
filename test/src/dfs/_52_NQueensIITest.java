package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _52_NQueensIITest {

    _52_NQueensII target = null;

    @Before
    public void before() throws Exception {
        target = new _52_NQueensII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTotalNQueens1() throws Exception {
        int solutions = target.totalNQueens(1);
        assertEquals(1, solutions);
    }

    @Test
    public void testTotalNQueens2() throws Exception {
        int solutions = target.totalNQueens(2);
        assertEquals(0, solutions);
    }

    @Test
    public void testTotalNQueens3() throws Exception {
        int solutions = target.totalNQueens(3);
        assertEquals(0, solutions);
    }

    @Test
    public void testTotalNQueens4() throws Exception {
        int solutions = target.totalNQueens(4);
        assertEquals(2, solutions);
    }

    @Test
    public void testTotalNQueens9() throws Exception {
        int solutions = target.totalNQueens(9);
        assertEquals(352, solutions);
    }

} 
