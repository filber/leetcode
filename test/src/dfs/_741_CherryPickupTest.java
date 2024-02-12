package dfs;

import dfs._741_CherryPickup;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _741_CherryPickupTest {

    _741_CherryPickup target;

    @Before
    public void setUp() throws Exception {
        target = new _741_CherryPickup();
    }

    @Test
    public void testCherryPickup1() {
        // 0
        int score = target.cherryPickup(new int[][]{
                {1, 1, -1},
                {1, -1, 1},
                {-1, 1, 1}});
        assertEquals(0, score);
    }

    @Test
    public void testCherryPickup2() {
        // 5
        int score = target.cherryPickup(new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}});
        assertEquals(5, score);
    }

    @Test
    public void testCherryPickup3() {
        // 15
        int score = target.cherryPickup(new int[][]{
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}
        });
        assertEquals(15, score);
    }

    @Test
    public void testCherryPickup4() {
        // 23
        int score = target.cherryPickup(new int[][]{
                {1, -1, 1, 1, 1, 1, 1, 1, -1, 1},
                {1, 1, 1, 1, -1, -1, 1, 1, 1, 1},
                {-1, 1, 1, -1, 1, 1, 1, 1, 1, 1},
                {1, 1, -1, 1, -1, 1, 1, 1, 1, 1},
                {-1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {-1, -1, 1, 1, 1, -1, 1, 1, -1, 1},
                {1, 1, 1, 1, 1, 1, 1, -1, 1, 1},
                {1, 1, 1, 1, -1, 1, -1, -1, 1, 1},
                {1, -1, 1, -1, -1, 1, 1, -1, 1, -1},
                {-1, 1, -1, 1, -1, 1, 1, 1, 1, 1}});
        assertEquals(23, score);
    }
}