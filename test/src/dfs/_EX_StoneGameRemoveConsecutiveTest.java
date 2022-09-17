package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_StoneGameRemoveConsecutiveTest {

    _EX_StoneGameRemoveConsecutive target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_StoneGameRemoveConsecutive();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testStoneGame1() throws Exception {
        int[] arr = {1, 4, 5, 5, 6};
        boolean win = target.stoneGame(arr);
        // [1,4,5,5,6] --Alice--> [1,4,6]
        assertTrue(win); // alice win
    }

    @Test
    public void testStoneGame2() throws Exception {
        int[] arr = {1, 3, 3, 1, 5};
        boolean win = target.stoneGame(arr);
        // [1,3,3,1,5] --Alice--> [1,1,5] --Bob--> [5]
        assertFalse(win); // Bob win
    }

    @Test
    public void testStoneGame3() throws Exception {
        int[] arr = {1, 2, 2, 3, 3, 1, 1};
        boolean win = target.stoneGame(arr);
        // [1,2,2,3,3,1,1] --Alice(2)--> [1,3,3,1,1] --Bob(3)--> [1,1,1] --Alice(1)-->[1]   Alice win
        //                                           --Bob(1)--> [1,3,3] --Alice(3)-->[1]   Alice win
        // [1,2,2,3,3,1,1] --Alice(3)--> [1,2,2,1,1] --Bob(2)--> [1,1,1] --Alice(1)-->[1]   Alice win
        //                                           --Bob(1)--> [1,2,2] --Alice(2)-->[1]   Alice win
        // [1,2,2,3,3,1,1] --Alice(1)--> [1,2,2,3,3] --Bob(2)--> [1,3,3] --Alice(3)-->[1]   Alice win
        //                                           --Bob(3)--> [1,2,2] --Alice(2)-->[1]   Alice win
        assertTrue(win); // Alice win
    }

    @Test
    public void testStoneGame4() throws Exception {
        int[] arr = {1, 1};
        boolean win = target.stoneGame(arr);
        // [1,1] --Alice--> []
        assertTrue(win); // alice win
    }

    @Test
    public void testStoneGame5() throws Exception {
        int[] arr = {1, 2};
        boolean win = target.stoneGame(arr);
        // [1,2]
        assertFalse(win); // Bob lose
    }
}
