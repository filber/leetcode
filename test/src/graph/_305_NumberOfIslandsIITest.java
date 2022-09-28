package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _305_NumberOfIslandsIITest {

    _305_NumberOfIslandsII target;

    @Before
    public void before() throws Exception {
        target = new _305_NumberOfIslandsII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumIslands21() throws Exception {
        int m = 3;
        int n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        int[] islands = target.numIslands2(m, n, positions);
        assertArrayEquals(new int[]{1, 1, 2, 3}, islands);
    }

    @Test
    public void testNumIslands22() throws Exception {
        int m = 3;
        int n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {0, 2}, {1, 2}};
        int[] islands = target.numIslands2(m, n, positions);
        assertArrayEquals(new int[]{1, 1, 1, 1}, islands);
    }
}
