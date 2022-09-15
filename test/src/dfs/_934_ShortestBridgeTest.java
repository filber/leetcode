package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _934_ShortestBridgeTest {

    _934_ShortestBridge target = null;

    @Before
    public void before() throws Exception {
        target = new _934_ShortestBridge();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testShortestBridge1() throws Exception {
        int[][] grid = {{0, 1}, {1, 0}};
        int distance = target.shortestBridge(grid);
        assertEquals(1, distance);
    }

    @Test
    public void testShortestBridge2() throws Exception {
        int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        int distance = target.shortestBridge(grid);
        assertEquals(2, distance);
    }

    @Test
    public void testShortestBridge3() throws Exception {
        int[][] grid = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        int distance = target.shortestBridge(grid);
        assertEquals(1, distance);
    }
}
