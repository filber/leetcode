package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _200_NumberOfIslandsTest {

    _200_NumberOfIslands target;

    @Before
    public void before() throws Exception {
        target = new _200_NumberOfIslands();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumIslands1() throws Exception {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int islands = target.numIslands(grid);
        assertEquals(1, islands);
    }

    @Test
    public void testNumIslands2() throws Exception {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int islands = target.numIslands(grid);
        assertEquals(3, islands);
    }
}
