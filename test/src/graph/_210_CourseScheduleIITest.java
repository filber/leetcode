package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _210_CourseScheduleIITest {

    _210_CourseScheduleII target = null;

    @Before
    public void before() throws Exception {
        target = new _210_CourseScheduleII();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindOrder1() throws Exception {
        int[] order = target.findOrder(2, new int[][]{{1, 0}});
        assertArrayEquals(new int[]{0, 1}, order);
    }

    @Test
    public void testFindOrder2() throws Exception {
        int[] order = target.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertArrayEquals(new int[]{0, 1, 2, 3}, order);
    }

    @Test
    public void testFindOrder3() throws Exception {
        int[] order = target.findOrder(1, new int[][]{});
        assertArrayEquals(new int[]{0}, order);
    }

    @Test
    public void testFindOrder4() throws Exception {
        int[] order = target.findOrder(2, new int[][]{});
        assertArrayEquals(new int[]{0, 1}, order);
    }

    @Test
    public void testFindOrder5() throws Exception {
        int[] order = target.findOrder(2, new int[][]{{1, 0}, {0, 1}});
        assertEquals(0, order.length);
    }

    @Test
    public void testFindOrder6() throws Exception {
        int[] order = target.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {0, 3}});
        assertEquals(0, order.length);
    }
}
