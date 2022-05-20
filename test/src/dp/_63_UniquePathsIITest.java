package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _63_UniquePathsIITest {

    _63_UniquePathsII target = null;

    @Before
    public void before() throws Exception {
        target = new _63_UniquePathsII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testUniquePathsWithObstacles1() throws Exception {
        int[][] obstacleGrid = {
                {1}
        };
        int paths = target.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(0, paths);
    }

    @Test
    public void testUniquePathsWithObstacles2() throws Exception {
        int[][] obstacleGrid = {
                {0}
        };
        int paths = target.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(1, paths);
    }

    @Test
    public void testUniquePathsWithObstacles3() throws Exception {
        int[][] obstacleGrid = {
                {0, 0},
                {0, 1}
        };
        int paths = target.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(0, paths);
    }

    @Test
    public void testUniquePathsWithObstacles4() throws Exception {
        int[][] obstacleGrid = {
                {0, 1},
                {0, 0}
        };
        int paths = target.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(1, paths);
    }

    @Test
    public void testUniquePathsWithObstacles5() throws Exception {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int paths = target.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(2, paths);
    }
} 
