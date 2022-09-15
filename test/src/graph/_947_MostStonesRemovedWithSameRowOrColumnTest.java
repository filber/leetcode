package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _947_MostStonesRemovedWithSameRowOrColumnTest {

    _947_MostStonesRemovedWithSameRowOrColumn target = null;

    @Before
    public void before() throws Exception {
        target = new _947_MostStonesRemovedWithSameRowOrColumn();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testRemoveStones1() throws Exception {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int removes = target.removeStones(stones);
        assertEquals(5, removes);
    }

    @Test
    public void testRemoveStones2() throws Exception {
        int[][] stones = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        int removes = target.removeStones(stones);
        assertEquals(3, removes);
    }

    @Test
    public void testRemoveStones3() throws Exception {
        int[][] stones = {{0, 0}};
        int removes = target.removeStones(stones);
        assertEquals(0, removes);
    }
}
