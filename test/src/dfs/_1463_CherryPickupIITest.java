package dfs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1463_CherryPickupIITest {

    _1463_CherryPickupII target;

    @Before
    public void setUp() {
        target = new _1463_CherryPickupII();
    }

    @Test
    public void testCherryPickup1() {
        int score = target.cherryPickup(
                new int[][]{
                        {3, 1, 1},
                        {2, 5, 1},
                        {1, 5, 5},
                        {2, 1, 1}});
        assertEquals(24, score);
    }

    @Test
    public void testCherryPickup2() {
        int score = target.cherryPickup(
                new int[][]{
                        {1, 0, 0, 0, 0, 0, 1},
                        {2, 0, 0, 0, 0, 3, 0},
                        {2, 0, 9, 0, 0, 0, 0},
                        {0, 3, 0, 5, 4, 0, 0},
                        {1, 0, 2, 3, 0, 0, 6}
                });
        assertEquals(28, score);
    }
}