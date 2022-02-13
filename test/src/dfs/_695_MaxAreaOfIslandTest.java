package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _695_MaxAreaOfIslandTest {

    _695_MaxAreaOfIsland target = null;

    @Before
    public void before() throws Exception {
        target = new _695_MaxAreaOfIsland();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxAreaOfIslandOneIsland() throws Exception {
        int maxArea = target.maxAreaOfIsland(new int[][]{{1}});
        assertEquals(1, maxArea);
    }

    @Test
    public void testMaxAreaOfIslandNoIsland() throws Exception {
        int maxArea = target.maxAreaOfIsland(new int[][]{{0}});
        assertEquals(0, maxArea);
    }

    @Test
    public void testMaxAreaOfIslandNoIsland2() throws Exception {
        int maxArea = target.maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}});
        assertEquals(0, maxArea);
    }

    @Test
    public void testMaxAreaOfIslandThree() throws Exception {
        int maxArea = target.maxAreaOfIsland(new int[][]{
                        {1, 0, 1, 1},
                        {1, 0, 1, 0}});
        assertEquals(3, maxArea);
    }

    @Test
    public void testMaxAreaOfIslandSix() throws Exception {
        int maxArea = target.maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}});
        assertEquals(6, maxArea);
    }

} 
