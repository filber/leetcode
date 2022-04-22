package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_TopologicalSortTest {

    _EX_TopologicalSort target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_TopologicalSort();
    }

    @After
    public void after() throws Exception {
    }


    //    5     4
    //   / \   / \
    //  v   v v   v
    //  2    0    1
    //   \       ^
    //     v   /
    //       3
    @Test
    public void testTopologicalOrder1() throws Exception {
        int[][] graph = {
                {},//0
                {},//1
                {3},//2
                {1},//3
                {0, 1},//4
                {0, 2},//5
        };
        assertArrayEquals(new int[]{5, 4, 2, 3, 1, 0}, target.topologicalOrder(graph));
        assertArrayEquals(new int[]{4, 5, 0, 2, 3, 1}, target.topologicalOrderBFS(graph));
    }
}
