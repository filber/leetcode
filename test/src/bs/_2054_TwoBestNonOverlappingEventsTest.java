package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2054_TwoBestNonOverlappingEventsTest {

    _2054_TwoBestNonOverlappingEvents target = null;

    @Before
    public void before() throws Exception {
        target = new _2054_TwoBestNonOverlappingEvents();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxTwoEvents1() throws Exception {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        int max = target.maxTwoEvents(events);
        assertEquals(4, max);
    }

    @Test
    public void testMaxTwoEvents2() throws Exception {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        int max = target.maxTwoEvents(events);
        assertEquals(5, max);
    }

    @Test
    public void testMaxTwoEvents3() throws Exception {
        int[][] events = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        int max = target.maxTwoEvents(events);
        assertEquals(8, max);
    }
}
