package pq;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _871_MinimumNumberOfRefuelingStopsTest {

    _871_MinimumNumberOfRefuelingStops target = null;

    @Before
    public void before() throws Exception {
        target = new _871_MinimumNumberOfRefuelingStops();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinRefuelStops1() throws Exception {
        int stops = target.minRefuelStops(1, 1, new int[][]{});
        assertEquals(0, stops);
    }

    @Test
    public void testMinRefuelStops2() throws Exception {
        int stops = target.minRefuelStops(100, 1, new int[][]{{10, 100}});
        assertEquals(-1, stops);
    }

    @Test
    public void testMinRefuelStops3() throws Exception {
        int stops = target.minRefuelStops(100, 10,
                new int[][]{
                        {10, 60},
                        {20, 30},
                        {30, 30},
                        {60, 40}
                });
        // 10 -> [10,60] -> [60,40] -> target
        assertEquals(2, stops);
    }
}
