package bfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _994_RottingOrangesTest {

    _994_RottingOranges target;

    @Before
    public void before() throws Exception {
        target = new _994_RottingOranges();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testOrangesRotting1() throws Exception {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int time = target.orangesRotting(grid);
        assertEquals(4, time);
    }

    @Test
    public void testOrangesRotting2() throws Exception {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}};
        //       ^ wont rot
        int time = target.orangesRotting(grid);
        assertEquals(-1, time);
    }

    @Test
    public void testOrangesRotting3() throws Exception {
        int[][] grid = {
                {0, 2}};
        int time = target.orangesRotting(grid);
        assertEquals(0, time);
    }

    @Test
    public void testOrangesRotting4() throws Exception {
        int[][] grid = {
                {0}};
        int time = target.orangesRotting(grid);
        assertEquals(0, time);
    }
}