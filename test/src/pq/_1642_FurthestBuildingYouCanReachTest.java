package pq;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1642_FurthestBuildingYouCanReachTest {

    _1642_FurthestBuildingYouCanReach target;

    @Before
    public void before() throws Exception {
        target = new _1642_FurthestBuildingYouCanReach();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFurthestBuilding1() throws Exception {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;
        int furthest = target.furthestBuilding(heights, bricks, ladders);
        assertEquals(4, furthest);
    }

    @Test
    public void testFurthestBuilding2() throws Exception {
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10;
        int ladders = 2;
        int furthest = target.furthestBuilding(heights, bricks, ladders);
        assertEquals(7, furthest);
    }

    @Test
    public void testFurthestBuilding3() throws Exception {
        int[] heights = {14, 3, 19, 3};
        int bricks = 17;
        int ladders = 0;
        int furthest = target.furthestBuilding(heights, bricks, ladders);
        assertEquals(3, furthest);
    }
}
