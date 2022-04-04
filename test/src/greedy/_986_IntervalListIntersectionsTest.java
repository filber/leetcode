package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _986_IntervalListIntersectionsTest {

    _986_IntervalListIntersections target = null;

    @Before
    public void before() throws Exception {
        target = new _986_IntervalListIntersections();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIntervalIntersection1() throws Exception {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] intersection = target.intervalIntersection(firstList, secondList);
        assertEquals(6, intersection.length);
        assertArrayEquals(new int[]{1, 2}, intersection[0]);
        assertArrayEquals(new int[]{5, 5}, intersection[1]);
        assertArrayEquals(new int[]{8, 10}, intersection[2]);
        assertArrayEquals(new int[]{15, 23}, intersection[3]);
        assertArrayEquals(new int[]{24, 24}, intersection[4]);
        assertArrayEquals(new int[]{25, 25}, intersection[5]);
    }

    @Test
    public void testIntervalIntersection2() throws Exception {
        int[][] firstList = {{1, 3}, {5, 9}};
        int[][] secondList = {};

        int[][] intersection = target.intervalIntersection(firstList, secondList);
        assertEquals(0, intersection.length);
    }
}
