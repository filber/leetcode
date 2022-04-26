package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1584_MinCostToConnectAllPointsTest {

    _1584_MinCostToConnectAllPoints target = null;

    @Before
    public void before() throws Exception {
        target = new _1584_MinCostToConnectAllPoints();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinCostConnectPoints1() throws Exception {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int minCost = target.minCostConnectPoints(points);
        assertEquals(20, minCost);
    }

    @Test
    public void testMinCostConnectPoints2() throws Exception {
        int[][] points = {{3, 12}, {-2, 5}, {-4, 1}};
        int minCost = target.minCostConnectPoints(points);
        assertEquals(18, minCost);
    }
}
