package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _130_SurroundedRegionsTest {

    _130_SurroundedRegions target = null;

    @Before
    public void before() throws Exception {
        target = new _130_SurroundedRegions();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSolve1() throws Exception {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        target.solve(board);
        char[][] expected = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        for (int i = 0; i < board.length; i++) {
            assertArrayEquals(expected[i], board[i]);
        }
    }

    @Test
    public void testSolve2() throws Exception {
        char[][] board = {
                {'X'},
        };
        target.solve(board);
        char[][] expected = {
                {'X'},
        };
        for (int i = 0; i < board.length; i++) {
            assertArrayEquals(expected[i], board[i]);
        }
    }

    @Test
    public void testSolve3() throws Exception {
        char[][] board = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        target.solve(board);
        char[][] expected = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        for (int i = 0; i < board.length; i++) {
            assertArrayEquals(expected[i], board[i]);
        }
    }

}
