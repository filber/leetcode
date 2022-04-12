package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _289_GameOfLifeTest {

    _289_GameOfLife target = null;

    @Before
    public void before() throws Exception {
        target = new _289_GameOfLife();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGameOfLife1() throws Exception {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        target.gameOfLife(board);
        assertArrayEquals(new int[]{0, 0, 0}, board[0]);
        assertArrayEquals(new int[]{1, 0, 1}, board[1]);
        assertArrayEquals(new int[]{0, 1, 1}, board[2]);
        assertArrayEquals(new int[]{0, 1, 0}, board[3]);
    }

    @Test
    public void testGameOfLife2() throws Exception {
        int[][] board = new int[][]{{1, 1}, {1, 0}};
        target.gameOfLife(board);
        assertArrayEquals(new int[]{1, 1}, board[0]);
        assertArrayEquals(new int[]{1, 1}, board[1]);
    }
}
