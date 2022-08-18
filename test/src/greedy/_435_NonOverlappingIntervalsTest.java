package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _435_NonOverlappingIntervalsTest {

    _435_NonOverlappingIntervals target = null;

    @Before
    public void before() throws Exception {
        target = new _435_NonOverlappingIntervals();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testEraseOverlapIntervals1() throws Exception {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int cnt = target.eraseOverlapIntervals(intervals);
        assertEquals(1, cnt);
    }

    @Test
    public void testEraseOverlapIntervals2() throws Exception {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        int cnt = target.eraseOverlapIntervals(intervals);
        assertEquals(2, cnt);
    }

    @Test
    public void testEraseOverlapIntervals3() throws Exception {
        int[][] intervals = {{1, 2}, {2, 3}};
        int cnt = target.eraseOverlapIntervals(intervals);
        assertEquals(0, cnt);
    }
}
