package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1167_MinimumCostToConnectSticksTest {

    _1167_MinimumCostToConnectSticks target = null;

    @Before
    public void before() throws Exception {
        target = new _1167_MinimumCostToConnectSticks();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testConnectSticks1() throws Exception {
        int[] sticks = new int[]{2, 4, 3};
        int cost = target.connectSticks(sticks);
        assertEquals(14, cost);
    }

    @Test
    public void testConnectSticks2() throws Exception {
        int[] sticks = new int[]{1, 8, 3, 5};
        int cost = target.connectSticks(sticks);
        assertEquals(30, cost);
    }

    @Test
    public void testConnectSticks3() throws Exception {
        int[] sticks = new int[]{1};
        int cost = target.connectSticks(sticks);
        assertEquals(0, cost);
    }
}
