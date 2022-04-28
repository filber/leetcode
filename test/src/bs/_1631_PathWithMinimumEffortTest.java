package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1631_PathWithMinimumEffortTest {

    _1631_PathWithMinimumEffort target = null;

    @Before
    public void before() throws Exception {
        target = new _1631_PathWithMinimumEffort();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinimumEffortPath1() throws Exception {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}};
        int effort = target.minimumEffortPath(heights);
        assertEquals(2, effort);
    }

    @Test
    public void testMinimumEffortPath2() throws Exception {
        int[][] heights = {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        };
        int effort = target.minimumEffortPath(heights);
        assertEquals(1, effort);
    }

    @Test
    public void testMinimumEffortPath3() throws Exception {
        int[][] heights = {
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        };
        int effort = target.minimumEffortPath(heights);
        assertEquals(0, effort);
    }

    @Test
    public void testMinimumEffortPath4() throws Exception {
        int[][] heights = {
                {1, 2},
                {3, 3},
        };
        int effort = target.minimumEffortPath(heights);
        assertEquals(1, effort);
    }

    @Test
    public void testMinimumEffortPath5() throws Exception {
        int[][] heights = {
                {1, 2},
                {3, 8},
                {5, 3}};
        int effort = target.minimumEffortPath(heights);
        assertEquals(2, effort);
    }

    @Test
    public void testMinimumEffortPath6() throws Exception {
        int[][] heights = {
                {3}
        };
        int effort = target.minimumEffortPath(heights);
        assertEquals(0, effort);
    }
}
