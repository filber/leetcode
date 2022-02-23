package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _207_CourseScheduleTest {

    _207_CourseSchedule target = null;

    @Before
    public void before() throws Exception {
        target = new _207_CourseSchedule();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCanFinish1() throws Exception {
        boolean can = target.canFinish(2, new int[][]{{1, 0}});
        assertTrue(can);
    }

    @Test
    public void testCanFinish2() throws Exception {
        boolean can = target.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        assertFalse(can);
    }

    @Test
    public void testCanFinish3() throws Exception {
        boolean can = target.canFinish(2, new int[][]{});
        assertTrue(can);
    }

    @Test
    public void testCanFinish4() throws Exception {
        boolean can = target.canFinish(5, new int[][]{
                {1, 0},
                {1, 4},
                {0, 3},
                {4, 3},
        });
        assertTrue(can);
    }

    @Test
    public void testCanFinish5() throws Exception {
        boolean can = target.canFinish(5, new int[][]{
                {1, 0},
                {1, 4},
                {0, 3},
                {4, 3},
                {3, 1},
        });
        assertFalse(can);
    }
}
