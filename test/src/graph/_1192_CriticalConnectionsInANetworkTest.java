package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _1192_CriticalConnectionsInANetworkTest {

    _1192_CriticalConnectionsInANetwork target = null;

    @Before
    public void before() throws Exception {
        target = new _1192_CriticalConnectionsInANetwork();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCriticalConnections1() throws Exception {
        // 1----2
        // |\   |
        // | \  |
        // |  \ |
        // |   \|
        // 3    0
        List<List<Integer>> connections = List.of(
                List.of(0, 1),
                List.of(1, 2),
                List.of(2, 0),
                List.of(1, 3)
        );
        int n = 4;
        List<List<Integer>> criticalPath = target.criticalConnections(n, connections);
        assertEquals(1, criticalPath.size());
        assertArrayEquals(new Integer[]{1, 3}, criticalPath.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testCriticalConnections2() throws Exception {
        // 0----1
        List<List<Integer>> connections = List.of(
                List.of(0, 1)
        );
        int n = 2;
        List<List<Integer>> criticalPath = target.criticalConnections(n, connections);
        assertEquals(1, criticalPath.size());
        assertArrayEquals(new Integer[]{0, 1}, criticalPath.get(0).toArray(new Integer[0]));
    }

    @Test
    public void testCriticalConnections3() throws Exception {
        // 0---1
        //  \ /
        //   2
        List<List<Integer>> connections = List.of(
                List.of(0, 1),
                List.of(0, 2),
                List.of(1, 2)
        );
        int n = 3;
        List<List<Integer>> criticalPath = target.criticalConnections(n, connections);
        assertTrue(criticalPath.isEmpty());
    }

    @Test
    public void testCriticalConnections4() throws Exception {
        // 1   2
        //  \ /
        //   0
        //   |
        //   3
        List<List<Integer>> connections = List.of(
                List.of(0, 1),
                List.of(0, 2),
                List.of(0, 3)
        );
        int n = 4;
        List<List<Integer>> criticalPath = target.criticalConnections(n, connections);
        assertEquals(3, criticalPath.size());
        assertArrayEquals(new Integer[]{0, 1}, criticalPath.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{0, 2}, criticalPath.get(1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{0, 3}, criticalPath.get(2).toArray(new Integer[0]));
    }

    @Test
    public void testCriticalConnections5() throws Exception {
        // 0---1----3---4
        //  \ /      \ /
        //   2        5
        List<List<Integer>> connections = List.of(
                List.of(0, 1),
                List.of(0, 2),
                List.of(1, 2),
                List.of(1, 3),
                List.of(3, 4),
                List.of(3, 5),
                List.of(4, 5)
        );
        int n = 6;
        List<List<Integer>> criticalPath = target.criticalConnections(n, connections);
        assertEquals(1, criticalPath.size());
        assertArrayEquals(new Integer[]{1, 3}, criticalPath.get(0).toArray(new Integer[0]));
    }
}
