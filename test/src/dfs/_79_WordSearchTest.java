package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _79_WordSearchTest {

    _79_WordSearch target = null;

    @Before
    public void before() throws Exception {
        target = new _79_WordSearch();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testExist1() throws Exception {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean exist = target.exist(board, word);
        assertTrue(exist);
    }

    @Test
    public void testExist2() throws Exception {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCD";
        boolean exist = target.exist(board, word);
        assertFalse(exist);
    }
}
