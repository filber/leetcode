package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _1462_CourseScheduleIVTest {

    _1462_CourseScheduleIV target = null;

    @Before
    public void before() throws Exception {
        target = new _1462_CourseScheduleIV();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCheckIfPrerequisite1() throws Exception {
        List<Boolean> list = target.checkIfPrerequisite(2,
                new int[][]{{1, 0}},
                new int[][]{{0, 1}, {1, 0}});

        assertEquals(2, list.size());
        assertFalse(list.get(0));
        assertTrue(list.get(1));
    }

    @Test
    public void testCheckIfPrerequisite2() throws Exception {
        List<Boolean> list = target.checkIfPrerequisite(
                2,
                new int[][]{},
                new int[][]{{0, 1}, {1, 0}});

        assertEquals(2, list.size());
        assertFalse(list.get(0));
        assertFalse(list.get(1));
    }

    @Test
    public void testCheckIfPrerequisite3() throws Exception {
        List<Boolean> list = target.checkIfPrerequisite(3,
                new int[][]{{1, 2}, {1, 0}, {2, 0}},
                new int[][]{{1, 0}, {1, 2}});

        assertEquals(2, list.size());
        assertTrue(list.get(0));
        assertTrue(list.get(1));
    }
}
