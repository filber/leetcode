package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1288_RemoveCoveredIntervalsTest {

    _1288_RemoveCoveredIntervals target = null;

    @Before
    public void before() throws Exception {
        target = new _1288_RemoveCoveredIntervals();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRemoveCoveredIntervals1() throws Exception {
        int cnt = target.removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}});
        assertEquals(2, cnt);
    }

    @Test
    public void testRemoveCoveredIntervals2() throws Exception {
        int cnt = target.removeCoveredIntervals(new int[][]{{1, 4}, {2, 3}});
        assertEquals(1, cnt);
    }

    @Test
    public void testRemoveCoveredIntervals3() throws Exception {
        int cnt = target.removeCoveredIntervals(new int[][]{{1, 2}, {1, 4}, {3, 4}});
        assertEquals(1, cnt);
    }
}
