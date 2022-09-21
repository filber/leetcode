package bfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _286_WallsAndGatesTest {

    _286_WallsAndGates target;

    @Before
    public void before() throws Exception {
        target = new _286_WallsAndGates();
    }

    @After
    public void after() throws Exception {
    }

    private static final int INF = Integer.MAX_VALUE;

    private void assertMatrix(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testNearestGate1() throws Exception {
        int[][] M = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF},
        };
        int[][] actual = target.nearestGate(M);
        int[][] expected = {
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}
        };
        assertMatrix(expected, actual);
    }

    @Test
    public void testNearestGate2() throws Exception {
        int[][] M = {
                {INF, -1, 0, INF},
                {INF, INF, -1, -1},
        };
        int[][] actual = target.nearestGate(M);
        int[][] expected = {
                {INF, -1, 0, 1},
                {INF, INF, -1, -1},
        };
        assertMatrix(expected, actual);
    }
}
