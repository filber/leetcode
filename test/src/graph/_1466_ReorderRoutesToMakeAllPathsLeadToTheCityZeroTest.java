package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest {

    _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero target = null;

    @Before
    public void before() throws Exception {
        target = new _1466_ReorderRoutesToMakeAllPathsLeadToTheCityZero();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinReorder1() throws Exception {
        int n = 6;
        int[][] connections = new int[][]{
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };
        int min = target.minReorder(n, connections);
        assertEquals(3, min);
    }

    @Test
    public void testMinReorder2() throws Exception {
        int n = 5;
        int[][] connections = new int[][]{
                {1, 0},
                {1, 2},
                {2, 3},
                {4, 2}
        };
        int min = target.minReorder(n, connections);
        assertEquals(2, min);
    }
}
