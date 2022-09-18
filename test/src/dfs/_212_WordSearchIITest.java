package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _212_WordSearchIITest {

    _212_WordSearchII target = null;

    @Before
    public void before() throws Exception {
        target = new _212_WordSearchII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindWords1() throws Exception {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> list = target.findWords(board, words);
        assertEquals(2, list.size());
        assertEquals("oath", list.get(0));
        assertEquals("eat", list.get(1));
    }

    @Test
    public void testFindWords2() throws Exception {
        char[][] board = {
                {'a', 'b'},
                {'c', 'd'}};
        String[] words = {"abcb"};
        List<String> list = target.findWords(board, words);
        assertEquals(0, list.size());
    }

    @Test
    public void testFindWords3() throws Exception {
        char[][] board = {
                {'a'}};
        String[] words = {"ab"};
        List<String> list = target.findWords(board, words);
        assertEquals(0, list.size());
    }
}
