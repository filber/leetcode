package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _743_NetworkDelayTimeTest {

    _743_NetworkDelayTime target = null;

    @Before
    public void before() throws Exception {
        target = new _743_NetworkDelayTime();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNetworkDelayTime1() throws Exception {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        int time = target.networkDelayTime(times, n, k);
        assertEquals(2, time);
    }

    @Test
    public void testNetworkDelayTime2() throws Exception {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 1;
        int time = target.networkDelayTime(times, n, k);
        assertEquals(1, time);
    }

    @Test
    public void testNetworkDelayTime3() throws Exception {
        int[][] times = {{1, 2, 1}};
        int n = 2;
        int k = 2;
        int time = target.networkDelayTime(times, n, k);
        assertEquals(-1, time);
    }
}
